package com.example.delivery.menu;

import android.os.Bundle;

import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.delivery.Loger;
import com.example.delivery.R;
import com.example.delivery.data.MyEntity;
import com.example.delivery.databinding.FragmentPositionBinding;
import com.example.delivery.favorites.FavoritesViewModel;

import java.util.Iterator;
import java.util.List;

public class FragmentPosition extends Fragment {
    private Toolbar toolbar;
    private Menu menu;
    private NavController navController;

    public MyEntity entity=null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentPositionBinding binding=FragmentPositionBinding.inflate(inflater);
        binding.setFragment(this);
        View view=binding.getRoot();
        MenuViewModel menuViewModel=new ViewModelProvider(requireActivity()).get(MenuViewModel.class);
        FavoritesViewModel favoritesViewModel=new ViewModelProvider(this).get(FavoritesViewModel.class);

        toolbar= (Toolbar) getActivity().findViewById(R.id.toolbar_up);
        menu=toolbar.getMenu();
        menu.clear();
        requireActivity().getMenuInflater().inflate(R.menu.menu_position,menu);

        menu.getItem(0).setOnMenuItemClickListener((MenuItem item)-> {
            Loger.log("Add favorite "+entity.getName());
            if (entity!=null) {
                favoritesViewModel.cheakPosition(entity);
            }
            return onOptionsItemSelected(item);
        });

       // int position=getArguments().getInt("position");
        String name=getArguments().getString("name");
        Loger.log("name "+name);
        List<MyEntity> list=menuViewModel.listLive.getValue();
        //entity=list.get(position);

        Iterator iterator=list.iterator();
        MyEntity entityTemp;
        while (iterator.hasNext()){
            entityTemp= (MyEntity) iterator.next();
            Loger.log("iterator name "+entityTemp.getName());
            if (name.equalsIgnoreCase(entityTemp.getName())) {
                entity = entityTemp;
                break;
            }
        }
        entityTemp=null;

        return  view;
    }
    @Override
    public void onStop() {
        super.onStop();
        menu.clear();
        requireActivity().getMenuInflater().inflate(R.menu.toolbar_menu_up,menu);

    }

}