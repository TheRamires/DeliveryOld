package com.example.deliverykotlin.components.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.deliverykotlin.R
import com.example.deliverykotlin.components.menu.adapter.BrandRecyclerAdapter
import com.example.deliverykotlin.data.Brand
import com.example.deliverykotlin.data.MyEntity
import com.example.deliverykotlin.databinding.FragmentSection1Binding
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*

class Section1Fragment : Fragment(), BrandRecyclerAdapter.OnPositionClickListener {
    private val viewModel : MenuViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding=FragmentSection1Binding.inflate(inflater)
        val view=binding.root

        var resyclerView= binding.recycler

        viewModel.getSection1Live()
        viewModel.brandLive.observe(viewLifecycleOwner, {list->
            var adapter= BrandRecyclerAdapter(list)
            adapter.setPositionClickListener(this)
            resyclerView.adapter=adapter
        })
        return view
    }

    override fun onPositionClick(view: View, brand: String) {
        viewModel.apply {
            sortListLive(Param.BRAND)
            paramName.setValue(brand)
            param.value=Param.BRAND
        }
        Navigation.findNavController(view).popBackStack()
    }
}