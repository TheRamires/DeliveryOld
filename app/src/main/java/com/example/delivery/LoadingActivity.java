package com.example.delivery;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.view.View;

public class LoadingActivity extends AppCompatActivity {
    private LoadingViewModel loadingViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        loadingViewModel=new ViewModelProvider(this).get(LoadingViewModel.class);
        loadingViewModel.getAllData();
        Intent intent = new Intent(this, MainActivity.class);
        loadingViewModel.isLoaded.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean==true){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    startActivity(intent);
                    remove();
                    finish();
                }
            }
        });


    }
    void  remove (){
        loadingViewModel.isLoaded.removeObservers(this);
    }
}