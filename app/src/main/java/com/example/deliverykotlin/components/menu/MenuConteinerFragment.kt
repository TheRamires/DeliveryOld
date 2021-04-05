package com.example.deliverykotlin.components.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.deliverykotlin.Loger
import com.example.deliverykotlin.R
import com.example.deliverykotlin.databinding.FragmentMenuConteinerBinding
import com.google.android.material.tabs.TabLayoutMediator

class MenuConteinerFragment : Fragment() {

    private lateinit var titleList: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Loger.message("fragment 2 onCreateView")
        (activity as AppCompatActivity).supportActionBar.apply {
            this?.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME)
            this?.setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE)
            this?.setDisplayHomeAsUpEnabled(true)
        }

        val binding=FragmentMenuConteinerBinding.inflate(inflater)
        binding.setFragment(this)
        val view =binding.root

        titleList=resources.getStringArray(R.array.title)

        val tabLayout=binding.tabs
        val viewPager=binding.pager
        val adapter: FragmentStateAdapter = PagerAdapterMenu(requireActivity())
        viewPager.adapter = adapter
        TabLayoutMediator(
            tabLayout, viewPager
        ) { tab, position -> tab.setText(titleList.get(position)) }.attach()

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Loger.message("fragment 2 onDestroyView")
    }
}