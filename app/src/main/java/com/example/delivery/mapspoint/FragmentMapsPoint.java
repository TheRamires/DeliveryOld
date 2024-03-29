package com.example.delivery.mapspoint;

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
import com.example.delivery.databinding.FragmentMapspointBinding;
import com.example.delivery.pager_Instruments.PagerAdapterRestaurants;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class FragmentMapsPoint extends Fragment {
    private Toolbar toolbar;
    private TextView title;
    private String [] titleList2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        titleList2=getResources().getStringArray(R.array.title2);
        FragmentMapspointBinding binding=FragmentMapspointBinding.inflate(inflater);
        binding.setFragment(this);
        View view=binding.getRoot();
        addDinamicView();

        TabLayout tabLayout=binding.tabs;
        ViewPager2 viewPager=binding.pager;
        FragmentStateAdapter adapter=new PagerAdapterRestaurants(requireActivity());
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
        title.setText(getResources().getString(R.string.mapspoint));
        toolbar.addView(title);
    }

    //Destroy Dinamic View
    @Override
    public void onStop() {
        super.onStop();
        toolbar.removeView(title);
    }
}