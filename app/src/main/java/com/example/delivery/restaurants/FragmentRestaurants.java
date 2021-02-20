package com.example.delivery.restaurants;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.delivery.R;
import com.example.delivery.databinding.FragmentRestaurantsBinding;
import com.example.delivery.pager_Instruments.PagerAdapterMenu;
import com.example.delivery.pager_Instruments.PagerAdapterRestaurans;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class FragmentRestaurants extends Fragment {
    private Toolbar toolbar;
    private TextView title;
    private String [] titleList2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        titleList2=getResources().getStringArray(R.array.title2);
        FragmentRestaurantsBinding binding=FragmentRestaurantsBinding.inflate(inflater);
        binding.setFragment(this);
        View view=binding.getRoot();
        addDinamicView();

        TabLayout tabLayout=binding.tabs;
        ViewPager2 viewPager=binding.pager;
        FragmentStateAdapter adapter=new PagerAdapterRestaurans(requireActivity());
        viewPager.setAdapter(adapter);
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(titleList2[position]);
            }
        }).attach();

        return view;
    }
    private void addDinamicView(){
        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar_up);
        title=new TextView(getActivity());
        title.setTextSize(20);
        title.setTextColor(Color.BLACK);
        title.setText("Restaurants");
        toolbar.addView(title);
    }

    //Destroy Dinamic View
    @Override
    public void onStop() {
        super.onStop();
        toolbar.removeView(title);
    }
}