package com.example.delivery.menu.adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.delivery.R;
import com.example.delivery.data.Entity;
import com.example.delivery.databinding.ItemListBinding;

import java.util.List;

public class RecyclerAdapterList extends RecyclerView.Adapter<RecyclerAdapterList.ItemList> {
    List<Entity> list;

    public RecyclerAdapterList(List<Entity> list){
        this.list=list;
    }

    @NonNull
    @Override
    public ItemList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        ItemListBinding binding=ItemListBinding.inflate(inflater,parent,false);
        return new ItemList(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ItemList holder, int position) {
        Bundle bundle=new Bundle();
        bundle.putInt("position",position);

        holder.binding.setEntity(list.get(position));
        holder.itemView.setOnClickListener((View v)-> {
            Navigation.findNavController(v).navigate(R.id.fragmentPosition, bundle);
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ItemList extends RecyclerView.ViewHolder{
        ItemListBinding binding;

        public ItemList(@NonNull View itemView) {
            super(itemView);
            binding= DataBindingUtil.bind(itemView);
        }
    }
}