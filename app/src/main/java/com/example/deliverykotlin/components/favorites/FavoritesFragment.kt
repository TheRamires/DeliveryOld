package com.example.deliverykotlin.components.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.room.Delete
import com.daimajia.swipe.util.Attributes
import com.example.deliverykotlin.R
import com.example.deliverykotlin.components.favorites.adapter.FavoritesRecyclerView
import com.example.deliverykotlin.databinding.FragmentFavoritesBinding
import org.koin.android.viewmodel.ext.android.viewModel

class FavoritesFragment : Fragment(), FavoritesRecyclerView.OnPositionClickListener {
    private val viewModel : FavoritesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar.apply {
            this?.setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE)
        }

        val binding =FragmentFavoritesBinding.inflate(inflater)
        binding.fragment=this
        val view=binding.root


        var recyclerView=binding.recycler

        viewModel.getFavoritesList()

        viewModel.favoritesListLive.observe(viewLifecycleOwner, {
            if (it.isEmpty()) {
                recyclerView.setVisibility(View.GONE)
                binding.emptyView.setVisibility(View.VISIBLE)
            } else {
                recyclerView.setVisibility(View.VISIBLE)
                binding.emptyView.setVisibility(View.GONE)
            }

            var adapter = FavoritesRecyclerView(requireContext(), it, viewModel)
            adapter.setPostionClickListener(this)
            recyclerView.adapter = adapter
            adapter.notifyDataSetChanged()

            adapter.setMode(Attributes.Mode.Single)

            recyclerView.setAdapter(adapter)

            /*recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    Log.e("RecyclerView", "onScrollStateChanged")
                }

                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                }
            })*/
        })

        return view
    }

    override fun OnPositionClick(view: View, id: Int) {
        var bundle=Bundle()
        bundle.putInt("id",id)
        view.findNavController().navigate(R.id.action_navigation_menu_to_detailFragment, bundle)
    }
}