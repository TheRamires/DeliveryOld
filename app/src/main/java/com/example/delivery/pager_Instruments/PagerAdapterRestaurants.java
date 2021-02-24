package com.example.delivery.pager_Instruments;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.delivery.mapspoint.FragmentMap;
import com.example.delivery.mapspoint.FragmentNearby;

public class PagerAdapterRestaurants extends FragmentStateAdapter {
    private int counter = 0;

    public PagerAdapterRestaurants(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new FragmentNearby();
            case 1:
                return new FragmentMap();

        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
