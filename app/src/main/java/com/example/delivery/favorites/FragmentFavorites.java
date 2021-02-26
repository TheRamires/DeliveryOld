package com.example.delivery.favorites;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.delivery.R;
import com.example.delivery.data.MyEntity;
import com.example.delivery.databinding.FragmentFavoritesBinding;
import com.example.delivery.menu.adapters.RecyclerAdapterList;

import java.util.List;

public class FragmentFavorites extends Fragment {
    private Toolbar toolbar;
    private TextView title;
    private NavController navController;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentFavoritesBinding binding=FragmentFavoritesBinding.inflate(inflater);
        binding.setFragment(this);
        View view=binding.getRoot();

        FavoritesViewModel viewModel=new ViewModelProvider(this).get(FavoritesViewModel.class);
        navController= Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        addDinamicView();

        viewModel.getListFavorites();
        RecyclerView recyclerView=binding.recycler;
        viewModel.favoritesLive.observe(getViewLifecycleOwner(), (List<MyEntity> list)-> {
                RecyclerView.Adapter adapter=new RecyclerAdapterList(list,true,viewModel);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
        });

        return view;
    }
    private void addDinamicView(){
        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar_up);
        title=new TextView(getActivity());
        title.setTextSize(20);
        title.setTextColor(Color.BLACK);
        title.setText(getResources().getString(R.string.favorites));
        toolbar.addView(title);
    }

    //Destroy Dinamic View
    @Override
    public void onStop() {
        super.onStop();
        toolbar.removeView(title);
    }
}