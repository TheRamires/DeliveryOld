package com.example.deliverykotlin.components.menu


import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapterMenu(@NonNull fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return Section1Fragment()
            1 -> return Section2Fragment()
        }
        return Section1Fragment()
    }

    override fun getItemCount(): Int {
        return 2
    }

}