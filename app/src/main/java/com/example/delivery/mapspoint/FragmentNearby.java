package com.example.delivery.mapspoint;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.delivery.databinding.FragmentNearbyBinding;

public class FragmentNearby extends Fragment {
    MapspointViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentNearbyBinding binding=FragmentNearbyBinding.inflate(inflater);
        viewModel = new ViewModelProvider(requireActivity()).get(MapspointViewModel.class);
        binding.setFragment(this);
        View view=binding.getRoot();

        viewModel.getGeopoint();
        return view;
    }
}