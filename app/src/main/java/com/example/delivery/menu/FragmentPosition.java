package com.example.delivery.menu;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

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
        View view=binding.getRoot();
        PositionViewModel viewModel=new ViewModelProvider(requireActivity()).get(PositionViewModel.class);
        FavoritesViewModel favoritesViewModel=new ViewModelProvider(this).get(FavoritesViewModel.class);
        int idPosition=getArguments().getInt("id");

        toolbar= (Toolbar) getActivity().findViewById(R.id.toolbar_up);
        menu=toolbar.getMenu();
        menu.clear();
        requireActivity().getMenuInflater().inflate(R.menu.menu_position,menu);

        menu.getItem(0).setOnMenuItemClickListener((MenuItem item)-> {
                Loger.log("setOnMenuItemClickListener "+idPosition);
                favoritesViewModel.onePosition(idPosition);
            return onOptionsItemSelected(item);
        });
       // int position=getArguments().getInt("position");
        viewModel.getPosition(idPosition);
        viewModel.positionLive.observe(getViewLifecycleOwner(), new Observer<MyEntity>() {
            @Override
            public void onChanged(MyEntity myEntity) {
                binding.setEntity(myEntity);
                //entity=myEntity;
            }
        });

        /*List<MyEntity> list=menuViewModel.listLive.getValue();

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
        entityTemp=null;*/

        return  view;
    }
    @Override
    public void onStop() {
        super.onStop();
        menu.clear();
        requireActivity().getMenuInflater().inflate(R.menu.toolbar_menu_up,menu);

    }

}