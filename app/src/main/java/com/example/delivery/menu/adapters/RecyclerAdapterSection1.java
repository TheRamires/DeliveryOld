package com.example.delivery.menu.adapters;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.delivery.Loger;
import com.example.delivery.databinding.ItemSection1Binding;

import java.util.List;

public class RecyclerAdapterSection1 extends RecyclerView.Adapter<RecyclerAdapterSection1.ItemSection1> {
    List<String> list;

    public RecyclerAdapterSection1 (List<String> list){
        this.list=list;
    }

    @NonNull
    @Override
    public ItemSection1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        ItemSection1Binding binding=ItemSection1Binding.inflate(inflater,parent,false);
        return new ItemSection1(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ItemSection1 holder, int position) {
        Loger.log("onBindViewHolder "+list.get(position));
        holder.binding.setImg(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ItemSection1 extends RecyclerView.ViewHolder {
        ItemSection1Binding binding;

        public ItemSection1(@NonNull View itemView) {
            super(itemView);
            binding=DataBindingUtil.bind(itemView);
        }
    }
}