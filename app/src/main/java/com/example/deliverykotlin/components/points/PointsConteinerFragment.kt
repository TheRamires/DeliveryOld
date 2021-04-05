package com.example.deliverykotlin.components.points

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.deliverykotlin.R
import com.example.deliverykotlin.components.menu.PagerAdapterMenu
import com.example.deliverykotlin.databinding.FragmentPointsConteinerBinding
import com.google.android.material.tabs.TabLayoutMediator

class PointsConteinerFragment : Fragment() {
    private lateinit var titleList2: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar.apply {
            this?.setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE)
        }
        titleList2=resources.getStringArray(R.array.title2)

        val binding =FragmentPointsConteinerBinding.inflate(inflater)
        binding.setFragment(this)
        val view =binding.root

        val tabLayout=binding.tabs
        val viewPager=binding.pager
        val adapter: FragmentStateAdapter = PagerAdapterPoints(requireActivity())
        viewPager.adapter = adapter
        TabLayoutMediator(
            tabLayout, viewPager
        ) { tab, position -> tab.setText(titleList2.get(position)) }.attach()


        return view
    }
}