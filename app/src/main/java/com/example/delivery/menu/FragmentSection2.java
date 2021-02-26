package com.example.delivery.menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.delivery.data.Param;
import com.example.delivery.databinding.FragmentSection2Binding;
import com.example.delivery.menu.adapters.RecyclerAdapterSection;

import java.util.List;

public class FragmentSection2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentSection2Binding binding=FragmentSection2Binding.inflate(inflater);
        binding.setFragment(this);
        View view=binding.getRoot();
        MenuViewModel viewModel=new ViewModelProvider(requireActivity()).get(MenuViewModel.class);
        RecyclerView recyclerView=binding.recycler;
        viewModel.getSection2();

        viewModel.section2Live.observe(getViewLifecycleOwner(), new Observer<List<Param>>() {
            @Override
            public void onChanged(List<Param> drawables) {
                RecyclerView.Adapter adapter=new RecyclerAdapterSection(drawables);
                recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getBaseContext(),
                        2,GridLayoutManager.VERTICAL,false));
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }
        });

        return view;
    }
}