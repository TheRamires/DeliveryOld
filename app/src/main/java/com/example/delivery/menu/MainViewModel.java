package com.example.delivery.menu;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.delivery.data.MyEntity;
import com.example.delivery.data.Param;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    MutableLiveData<List<MyEntity>> listLive=new MutableLiveData<>();
    MutableLiveData<List<Param>> section1Live=new MutableLiveData<>();
    MutableLiveData<List<Param>> section2Live=new MutableLiveData<>();
    private MainRepositoriy repo=new MainRepositoriy(section1Live,section2Live, listLive);

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public void getAllData(){
        repo.dataList();
        repo.params();
    }
}
