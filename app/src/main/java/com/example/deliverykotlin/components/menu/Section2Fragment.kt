package com.example.deliverykotlin.components.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.deliverykotlin.components.menu.adapter.BrandRecyclerAdapter
import com.example.deliverykotlin.components.menu.adapter.TypeRecyclerAdapter
import com.example.deliverykotlin.data.MyEntity
import com.example.deliverykotlin.databinding.FragmentSection2Binding
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*

class Section2Fragment : Fragment(), TypeRecyclerAdapter.OnPositionClickListener {
    private val viewModel : MenuViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding= FragmentSection2Binding.inflate(inflater)
        val view=binding.root

        var resyclerView= binding.recycler
        viewModel.getSection2Live()
        viewModel.typeLive.observe(viewLifecycleOwner, {list->
            var adapter= TypeRecyclerAdapter(list)
            adapter.setPositionClickListener(this)
            resyclerView.adapter=adapter
        })
        return view
    }

    override fun onPositionClick(view: View, type: String) {
        viewModel.apply {
            sortListLive(Param.TYPE)
            paramName.setValue(type)
            param.value=Param.TYPE
        }
        Navigation.findNavController(view).popBackStack()
    }
}