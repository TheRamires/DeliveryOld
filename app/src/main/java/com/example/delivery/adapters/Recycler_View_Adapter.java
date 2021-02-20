package com.example.delivery.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.delivery.data.Entity;
import com.example.delivery.databinding.ItemMenuBinding;

import java.util.List;

public class Recycler_View_Adapter extends RecyclerView.Adapter<Recycler_View_Adapter.DailyViewHolder> {
    List<Entity> list;

    public Recycler_View_Adapter(List<Entity> list){
        this.list=list;
    }

    @NonNull
    @Override
    public DailyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        ItemMenuBinding binding=ItemMenuBinding.inflate(inflater,parent,false);
        return new DailyViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull DailyViewHolder holder, int position) {
        holder.binding.setEntity(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class DailyViewHolder extends RecyclerView.ViewHolder{
        ItemMenuBinding binding;

        public DailyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding= DataBindingUtil.bind(itemView);
        }
    }
}