package com.example.delivery.menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.delivery.data.Param;
import com.example.delivery.databinding.FragmentSection1Binding;
import com.example.delivery.menu.adapters.RecyclerAdapterSection;

import java.util.List;

public class FragmentSection1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentSection1Binding binding=FragmentSection1Binding.inflate(inflater);
        binding.setFragment(this);
        View view=binding.getRoot();
        MenuViewModel viewModel=new ViewModelProvider(requireActivity()).get(MenuViewModel.class);

        viewModel.getSection1Draw();
        RecyclerView recyclerView=binding.recycler;

        viewModel.section1Live.observe(getViewLifecycleOwner(),(List<Param> list)-> {
                RecyclerView.Adapter adapter=new RecyclerAdapterSection(list);
                recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getBaseContext(),
                        2,GridLayoutManager.VERTICAL,false));
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
        });

        return view;
    }
}