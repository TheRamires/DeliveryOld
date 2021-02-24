package com.example.delivery.menu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.delivery.Loger;
import com.example.delivery.R;
import com.example.delivery.databinding.FragmentMenuSectionsBinding;
import com.example.delivery.pager_Instruments.PagerAdapterMenu;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class FragmentMenuSections extends Fragment {
    private Toolbar toolbar;
    private Button title;
    private NavController navController;
    private String [] titleList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        titleList=getResources().getStringArray(R.array.title);
        FragmentMenuSectionsBinding binding=FragmentMenuSectionsBinding.inflate(inflater);
        binding.setFragment(this);
        View view=binding.getRoot();
        navController= Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        addDinamicView();

        TabLayout tabLayout=binding.tabs;
        ViewPager2 viewPager=binding.pager;
        FragmentStateAdapter adapter=new PagerAdapterMenu(requireActivity());
        viewPager.setAdapter(adapter);
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(titleList[position]);
            }
        }).attach();

        /*//-------------------------------------View Pager---------------------------------
        tabLayout=binding.tabs;
        viewPager=binding.pager;
        pagerAdapter = new MyViewPagerAdapter(requireActivity());
        viewPager.setAdapter(pagerAdapter);
        */

        return view;
    }

    //---------------------------------------Dinamic view--------------------------------------
    private void addDinamicView(){
        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar_up);
        title = new Button(getActivity());
        title.setText(getResources().getString(R.string.menu));
        //title.setBackgroundColor(Color.parseColor("#FF6200EE"));
        title.setClickable(true);
        title.setTextSize(15);
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.popBackStack();
                Loger.log("Dinamic Text View is Cliked");
            }
        });
        toolbar.addView(title);
    }

    //Destroy Dinamic View
    @Override
    public void onStop() {
        super.onStop();
        toolbar.removeView(title);
    }
}