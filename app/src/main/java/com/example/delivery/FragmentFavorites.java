package com.example.delivery;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.delivery.databinding.FragmentFavoritesBinding;

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
        navController= Navigation.findNavController(requireActivity(),R.id.nav_host_fragment);
        addDinamicView();

        // Inflate the layout for this fragment
        return view;
    }
    private void addDinamicView(){
        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar_up);
        title=new TextView(getActivity());
        title.setTextSize(20);
        title.setTextColor(Color.BLACK);
        title.setText("Favorites");
        toolbar.addView(title);
    }

    //Destroy Dinamic View
    @Override
    public void onStop() {
        super.onStop();
        toolbar.removeView(title);
    }
}