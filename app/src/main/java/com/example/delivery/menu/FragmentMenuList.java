package com.example.delivery.menu;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.delivery.Loger;
import com.example.delivery.R;
import com.example.delivery.adapters.Recycler_View_Adapter;
import com.example.delivery.data.Entity;
import com.example.delivery.databinding.FragmentMenuListBinding;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class FragmentMenuList extends Fragment {
    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private FragmentStateAdapter pagerAdapter;
    private Toolbar toolbar;
    private Button title;
    private NavController navController;
    private MenuViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel=new ViewModelProvider(requireActivity()).get(MenuViewModel.class);

        FragmentMenuListBinding binding=FragmentMenuListBinding.inflate(inflater);
        binding.setFragment(this);
        View view=binding.getRoot();
        navController= Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        addDinamicView();

        //List Test
        viewModel.getData();

        RecyclerView recyclerView=binding.recyclerView;
        viewModel.listLive.observe(getViewLifecycleOwner(), (List<Entity> entities) ->{
            setList(recyclerView,entities);
        });

        return view;
    }
    private void setList (RecyclerView recyclerView, List<Entity> list){

        RecyclerView.Adapter adapter=new Recycler_View_Adapter(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
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
                navController.navigate(R.id.fragmentMenuSections,null,getNavOptions());
                Loger.log("Dinamic Text View is Cliked");
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

    //Destroy Dinamic View
    @Override
    public void onStop() {
        super.onStop();
        toolbar.removeView(title);
    }
}