package com.example.deliverykotlin.components.menu.adapter

import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.deliverykotlin.R
import com.example.deliverykotlin.data.MyEntity
import com.example.deliverykotlin.databinding.ItemListBinding

class EntityRecyclerAdapter(private val values: List<MyEntity>) :
    RecyclerView.Adapter<EntityRecyclerAdapter.MyViewHolder>() {
    lateinit var positionListener: OnPositionClickListener
    lateinit var counterListner: OnCounterClickListener

    override fun getItemCount() = values.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding=ItemListBinding.inflate(inflater, parent, false)

        return MyViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        var binding=holder.binding!!
        holder.binding?.setEntity(values[position])
    }
    fun setPostionClickListener(listener: OnPositionClickListener){
        positionListener=listener
    }
    fun setCounterClickListener(listener: OnCounterClickListener){
        counterListner=listener
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var binding: ItemListBinding?=null
        var countDownTimer: CountDownTimer?= null

        init {
            binding= DataBindingUtil.bind(itemView)
            binding!!.clickableLayout.setOnClickListener(this)
            binding!!.include.minusButton.setOnClickListener(this)
            binding!!.include.plusButton.setOnClickListener(this)
            binding!!.include.priceButton.setOnClickListener(this)

            countDownTimer= object: CountDownTimer(2000,1000){
                override fun onTick(millisUntilFinished: Long) {
                }

                override fun onFinish() {
                    binding!!.setSlideCounter(false)
                }
            }
        }

        override fun onClick(v: View?) {
            when (v?.id){
                R.id.clickable_layout ->positionListener.OnPositionClick(v!!, values[position].id)

                R.id.price_button,
                R.id.plus_button,
                R.id.minus_button -> counterListner.OnCounterClick(v,values[position],position)
            }
        }
    }

    interface OnPositionClickListener{
        fun OnPositionClick(view: View, id: Int)
    }
    interface OnCounterClickListener{
        fun OnCounterClick(view: View, entity: MyEntity,position: Int)
    }
}