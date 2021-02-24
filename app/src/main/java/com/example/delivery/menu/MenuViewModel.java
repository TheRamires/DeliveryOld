package com.example.delivery.menu;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.delivery.data.Entity;

import java.util.List;

public class MenuViewModel extends AndroidViewModel {
    MutableLiveData<List<Entity>> listLive=new MutableLiveData<>();
    MenuRepositoriy repo=new MenuRepositoriy();

    public MenuViewModel(@NonNull Application application) {
        super(application);
    }
    public void getData(){
    }
}
