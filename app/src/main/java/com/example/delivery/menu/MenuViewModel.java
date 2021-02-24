package com.example.delivery.menu;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.delivery.Loger;
import com.example.delivery.data.Entity;

import java.util.List;

public class MenuViewModel extends AndroidViewModel {
    MutableLiveData<List<Entity>> listLive=new MutableLiveData<>();
    MutableLiveData<List<String>> section1Live=new MutableLiveData<>();
    private MenuRepositoriy repo=new MenuRepositoriy();

    public MenuViewModel(@NonNull Application application) {
        super(application);
    }

    public void getData(){
        repo.requestData(listLive);
    }
    public void getSection1Draw(){
        repo.requestParams1(section1Live);
    }
}
