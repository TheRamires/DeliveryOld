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

import java.util.Iterator;
import java.util.List;

public class FragmentPosition extends Fragment {
    private Toolbar toolbar;
    private Button title;
    private NavController navController;
    public MyEntity entity=null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentPositionBinding binding=FragmentPositionBinding.inflate(inflater);
        binding.setFragment(this);
        View view=binding.getRoot();

        Toolbar actionMenu=binding.actionMenu;
        Menu menu=actionMenu.getMenu();
        requireActivity().getMenuInflater().inflate(R.menu.menu_position, menu);
        for (int i = 0; i < menu.size(); i++) {
            menu.getItem(i).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    if (item.getItemId() == R.id.item){
                        Loger.log("Position menu click");
                    }
                    return onOptionsItemSelected(item);
                }
            });
        }

        MenuViewModel viewModel=new ViewModelProvider(requireActivity()).get(MenuViewModel.class);

       // int position=getArguments().getInt("position");
        String name=getArguments().getString("name");
        Loger.log("name "+name);
        List<MyEntity> list=viewModel.listLive.getValue();
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
}