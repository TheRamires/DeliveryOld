package com.example.delivery;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.delivery.databinding.FragmentProfileBinding;

public class FragmentProfile extends Fragment {
    private Toolbar toolbar;
    private TextView title;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentProfileBinding binding=FragmentProfileBinding.inflate(inflater);
        binding.setFragment(this);
        View view=binding.getRoot();
        addDinamicView();
        return view;
    }
    private void addDinamicView(){
        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar_up);
        title=new TextView(getActivity());
        title.setTextSize(20);
        title.setTextColor(Color.BLACK);
        title.setText("Profile");
        toolbar.addView(title);
    }

    //Destroy Dinamic View
    @Override
    public void onStop() {
        super.onStop();
        toolbar.removeView(title);
    }
}