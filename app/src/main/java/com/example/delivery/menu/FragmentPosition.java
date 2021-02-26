package com.example.delivery.menu;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.delivery.Loger;
import com.example.delivery.R;
import com.example.delivery.data.Entity;
import com.example.delivery.databinding.FragmentPositionBinding;

import java.util.Iterator;
import java.util.List;

public class FragmentPosition extends Fragment {
    private Toolbar toolbar;
    private Button title;
    private NavController navController;
    public Entity entity=null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentPositionBinding binding=FragmentPositionBinding.inflate(inflater);
        binding.setFragment(this);
        View view=binding.getRoot();
        MenuViewModel viewModel=new ViewModelProvider(requireActivity()).get(MenuViewModel.class);

       // int position=getArguments().getInt("position");
        String name=getArguments().getString("name");
        Loger.log("name "+name);
        List<Entity> list=viewModel.listLive.getValue();
        //entity=list.get(position);

        Iterator iterator=list.iterator();
        Entity entityTemp;
        while (iterator.hasNext()){
            entityTemp= (Entity) iterator.next();
            Loger.log("iterator name "+entityTemp.getName());
            if (name.equalsIgnoreCase(entityTemp.getName())) {
                entity = entityTemp;
                break;
            }
        }
        entityTemp=null;

        return  view;
    }
}