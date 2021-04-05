package com.example.deliverykotlin.components.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import com.example.deliverykotlin.CartViewModel
import com.example.deliverykotlin.R
import com.example.deliverykotlin.adapters.RecyclerSectionItemDecoration
import com.example.deliverykotlin.components.menu.adapter.EntityRecyclerAdapter
import com.example.deliverykotlin.components.menu.adapter.EntityRecyclerAdapter.*
import com.example.deliverykotlin.data.MyEntity
import com.example.deliverykotlin.databinding.FragmentMenuListBinding
import org.koin.android.viewmodel.ext.android.viewModel


class MenuListFragment : Fragment(), OnPositionClickListener, OnCounterClickListener{
    private val viewModel : MenuViewModel by viewModel()
    private val cartViewModel : CartViewModel by viewModel()
    private lateinit var actionBar:ActionBar
    private lateinit var recyclerAdapter:EntityRecyclerAdapter
    private lateinit var recyclerView:RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding=FragmentMenuListBinding.inflate(inflater)
        val view =binding.root

        //for action bar
        val customView=inflater.inflate(R.layout.custom_button_menu, null).also {
            it.findViewById<TextView>(R.id.btn_menu).text="Sections"
            it.setOnClickListener { v->
               Navigation.findNavController(view)
                   .navigate(
                       R.id.action_navigation_menu_to_menuConteinerFragment2,
                       null,
                       getNavOptions()
                   )
            }
        }
        actionBar= (activity as AppCompatActivity)!!.supportActionBar!!.apply {
            this?.setCustomView(customView)
            this?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        }
        recyclerView=binding.recycler
        (recyclerView.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false

        viewModel.listLive.observe(viewLifecycleOwner, { list ->
            val recyclerSectionItemDecoration = getDecorForSection1(list, viewModel.param.value!!)
            recyclerAdapter = EntityRecyclerAdapter(list).also {
                it.setPostionClickListener(this)
                it.setCounterClickListener(this)
            }

            recyclerView.apply {
                this?.adapter = recyclerAdapter
                this.addItemDecoration(recyclerSectionItemDecoration!!)
            }
            var position = 0
            viewModel.paramName?.let {
                position = viewModel.findPosition(list)
            }
            recyclerView.scrollToPosition(position)
        })

        return view
    }

    fun getDecorForSection1(list: List<MyEntity>, param: Param): RecyclerSectionItemDecoration? {
        return RecyclerSectionItemDecoration(
            requireContext().resources
                .getDimensionPixelSize(R.dimen.recycler_section_header_height),
            true,  // true for sticky, false for not
            object : RecyclerSectionItemDecoration.SectionCallback {
                override fun isSection(position: Int): Boolean {
                    when (param) {
                        Param.BRAND -> {
                            return (position == 0
                                    || list[position] //.getLastName()
                                .brand.get(0) !== list[position - 1] //.getLastName()
                                .brand.get(0))
                        }
                        Param.TYPE -> {
                            return (position == 0
                                    || list[position] //.getLastName()
                                .type.get(0) !== list[position - 1] //.getLastName()
                                .type.get(0))
                        }
                    }
                }

                override fun getSectionHeader(position: Int): CharSequence {
                    when (param) {
                        Param.BRAND -> {
                            return list[position]
                                .brand

                        }
                        Param.TYPE -> {
                            return list[position]
                                .type
                        }
                    }
                }
            })
    }
    fun getNavOptions():NavOptions{
        val navOptions=NavOptions.Builder()
            .setEnterAnim(R.animator.slide_down)
            .setExitAnim(R.animator.anim_stay)
            //.setPopEnterAnim(R.animator.slide_down)
            .setPopExitAnim(R.animator.slide_up)
            .build()
        return navOptions
    }

    override fun OnPositionClick(view: View, id: Int) {
        var bundle=Bundle()
        bundle.putInt("id", id)
        view.findNavController().navigate(R.id.action_navigation_menu_to_detailFragment, bundle)
    }

    override fun OnCounterClick(view: View, entity: MyEntity, position: Int) {
        when(view.id){
            R.id.price_button -> {
                val added=entity.addPostion()
                if (added){
                    //count
                }
                entity.counterVisible = true
                cartViewModel.getCountDownTimerVisible(entity,recyclerAdapter, position)
                cartViewModel.startTimer()
            }
            R.id.plus_button->{
                val plus=entity.plusPosition()
                if (plus){
                    //count
                }
                cartViewModel.refreshTimer()
            }
            R.id.minus_button->{
                val minus=entity.minusPosition()
                if (minus){
                    //count
                }
                cartViewModel.refreshTimer()
            }
        }
        recyclerAdapter.notifyItemChanged(position)
    }
}