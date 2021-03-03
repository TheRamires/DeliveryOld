package com.example.delivery.adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.delivery.Loger;
import com.example.delivery.R;
import com.example.delivery.data.MyEntity;
import com.example.delivery.databinding.ItemListBinding;
import com.example.delivery.favorites.FavoritesViewModel;

import java.util.List;

public class RecyclerAdapterList extends RecyclerView.Adapter<RecyclerAdapterList.ItemList> {
    private List<MyEntity> list;
    private Boolean crosVisible=false;
    private FavoritesViewModel favoritesViewModel;

    public RecyclerAdapterList(List<MyEntity> list){
        this.list=list;
    }
    public RecyclerAdapterList(List<MyEntity> list, Boolean crosVisible, FavoritesViewModel favoritesViewModel){
        this.list=list;
        this.crosVisible=crosVisible;
        this.favoritesViewModel=favoritesViewModel;
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
        //bundle.putInt("position",position);
        if (crosVisible){
            holder.binding.setIsVisible(true);
            holder.binding.cros.setOnClickListener((View v) ->{
                Loger.log("onClick id "+list.get(position).getId()+" name "+list.get(position).getName());
                favoritesViewModel.deleteOne(list.get(position).getId());
            });
        }
        holder.binding.setEntity(list.get(position));
        holder.itemView.setOnClickListener((View v)-> {
            bundle.putInt("id",list.get(position).getId());
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