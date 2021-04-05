package com.example.deliverykotlin.components.favorites.adapter

import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.swipe.SwipeLayout
import com.example.deliverykotlin.R
import java.util.*
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter
import com.example.deliverykotlin.components.favorites.FavoritesViewModel
import com.example.deliverykotlin.components.menu.adapter.EntityRecyclerAdapter
import com.example.deliverykotlin.data.MyEntity
import com.example.deliverykotlin.databinding.ItemFavoritesBinding

class FavoritesRecyclerView (context: Context, objects: List<MyEntity>?, viewModel : FavoritesViewModel):
    RecyclerSwipeAdapter<FavoritesRecyclerView.SimpleViewHolder>() {
    lateinit var positionListener: OnPositionClickListener

    var mContext: Context? = context
    var list: ArrayList<MyEntity> = objects as ArrayList<MyEntity>
    val viewModel=viewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemFavoritesBinding = ItemFavoritesBinding.inflate(inflater, parent, false)
        return SimpleViewHolder(binding.getRoot())
    }

    override fun onBindViewHolder(viewHolder: SimpleViewHolder, position: Int) {

        val item: MyEntity = list!![position]
        viewHolder.binding?.setEntity(list!![position])
        viewHolder.binding?.swipe?.setShowMode(SwipeLayout.ShowMode.PullOut)

        //dari kanan
        viewHolder.binding!!.swipe.addDrag(
            SwipeLayout.DragEdge.Right, viewHolder.binding!!.swipe.findViewById(R.id.bottom_wraper))

        viewHolder.binding!!.swipe.addSwipeListener(object : SwipeLayout.SwipeListener {
            override fun onStartOpen(layout: SwipeLayout?) {}
            override fun onOpen(layout: SwipeLayout?) {}
            override fun onStartClose(layout: SwipeLayout?) {}
            override fun onClose(layout: SwipeLayout?) {}
            override fun onUpdate(layout: SwipeLayout?, leftOffset: Int, topOffset: Int) {}
            override fun onHandRelease(layout: SwipeLayout?, xvel: Float, yvel: Float) {}
        })

        viewHolder.binding!!.swipe.getSurfaceView().setOnClickListener(View.OnClickListener { v ->
            val bundle = Bundle()
            bundle.putInt("id", list!![position].id)
            Navigation.findNavController(v).navigate(R.id.detailFragment, bundle)
        })

        viewHolder.binding!!.Delete.setOnClickListener(View.OnClickListener { v ->
            viewModel.deleteExactly(list[position].id) //Удаление из БД

            mItemManger.removeShownLayouts(viewHolder.binding!!.swipe)
            list!!.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, list!!.size)

            mItemManger.closeAllItems()
            Toast.makeText(v.context, "Deleted " + viewHolder.binding!!.include.model.getText().toString(),
                    Toast.LENGTH_SHORT).show()
        })

        mItemManger.bindView(viewHolder.itemView, position)
    }
    fun setPostionClickListener(listener: OnPositionClickListener){
        positionListener=listener
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun getSwipeLayoutResourceId(position: Int): Int {
        return R.id.swipe
    }

    inner class SimpleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var binding: ItemFavoritesBinding?

        init {
            binding = DataBindingUtil.bind(itemView)
            binding!!.include.clickableLayout.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            positionListener.OnPositionClick(v!!, list[position].id)
        }
    }

    interface OnPositionClickListener{
        fun OnPositionClick(view: View, id: Int)
    }
}
