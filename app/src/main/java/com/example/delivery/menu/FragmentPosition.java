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

import java.util.List;

public class FragmentPosition extends Fragment {
    private Toolbar toolbar;
    private Button title;
    private NavController navController;
    public Entity entity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentPositionBinding binding=FragmentPositionBinding.inflate(inflater);
        binding.setFragment(this);
        View view=binding.getRoot();
        MenuViewModel viewModel=new ViewModelProvider(requireActivity()).get(MenuViewModel.class);

        int position=getArguments().getInt("position");
        List<Entity> list=viewModel.listLive.getValue();
        entity=list.get(position);


        return  view;
    }

    //---------------------------------------Dinamic view--------------------------------------
    private void addDinamicView(){
        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar_up);
        title = new Button(getActivity());
        title.setText(getResources().getString(R.string.menu_sections));
        //title.setBackgroundColor(Color.parseColor("#FF6200EE"));
        title.setClickable(true);
        title.setTextSize(15);
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNavOptions();
                navController.navigate(R.id.fragmentSectionContainer,null,getNavOptions());
                Loger.log("Dinamic Text View is Clicked");
            }
        });
        toolbar.addView(title);
    }
    protected NavOptions getNavOptions() {

        NavOptions navOptions = new NavOptions.Builder()
                .setEnterAnim(R.animator.slide_down)
                //.setExitAnim(R.animator.slide_up)
                //.setPopEnterAnim(R.animator.slide_down)
                .setPopExitAnim(R.animator.slide_up)
                .build();

        return navOptions;
    }
}