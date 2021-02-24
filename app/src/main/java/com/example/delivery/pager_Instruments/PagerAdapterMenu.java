package com.example.delivery.pager_Instruments;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.delivery.menu.FragmentSection2;
import com.example.delivery.menu.FragmentSection1;

public class PagerAdapterMenu extends FragmentStateAdapter {
    private int counter = 0;

    public PagerAdapterMenu(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new FragmentSection1();
            case 1:
                return new FragmentSection2();

        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
