package com.example.deliverykotlin.components.menu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.deliverykotlin.components.menu.MenuViewModel
import com.example.deliverykotlin.components.menu.Param
import com.example.deliverykotlin.data.Type
import com.example.deliverykotlin.databinding.ItemSection2Binding

class TypeRecyclerAdapter (
    private val values: List<Type>
) :
    RecyclerView.Adapter<TypeRecyclerAdapter.MyViewHolder>() {
    lateinit var positionListener: OnPositionClickListener

    override fun getItemCount() = values.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding= ItemSection2Binding.inflate(inflater,parent,false)

        return MyViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding?.setParam(values[position])
    }
    fun setPositionClickListener(listener: OnPositionClickListener){
        positionListener=listener
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var binding: ItemSection2Binding?=null

        init {
            binding= DataBindingUtil.bind(itemView)
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            positionListener.onPositionClick(v!!,values[position].name)
        }
    }
    interface OnPositionClickListener{
        fun onPositionClick(view: View, type: String)
    }
}