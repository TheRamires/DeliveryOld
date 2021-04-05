package com.example.deliverykotlin.components.points


import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapterPoints(@NonNull fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return PointFragment()
            1 -> return MapFragment()
        }
        return PointFragment()
    }

    override fun getItemCount(): Int {
        return 2
    }

}