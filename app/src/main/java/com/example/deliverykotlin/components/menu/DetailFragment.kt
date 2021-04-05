package com.example.deliverykotlin.components.menu

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.deliverykotlin.Loger
import com.example.deliverykotlin.R
import com.example.deliverykotlin.components.favorites.FavoritesViewModel
import com.example.deliverykotlin.databinding.FragmentDetailBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {
    private val viewModel : MenuViewModel by viewModel()
    private val favoritesViewModel : FavoritesViewModel by viewModel()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding=FragmentDetailBinding.inflate(inflater)
        val view=binding.root

        (activity as AppCompatActivity).supportActionBar?.apply {
            setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME)
            setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE)
            setDisplayHomeAsUpEnabled(true)
        }

        var id=arguments?.getInt("id")?.let {
            viewModel.getPositionById(it)
        }

        viewModel.currentPostion.observe(viewLifecycleOwner, {v->
            binding.entity=v
        })

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_deatail,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_favorites->{
                favoritesViewModel.clickFaforitePosition(
                        viewModel.currentPostion.value
                )
                return true
            }
            else->false
        }
        return super.onOptionsItemSelected(item)
    }
}