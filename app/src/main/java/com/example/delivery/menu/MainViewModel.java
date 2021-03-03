package com.example.delivery.menu;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.delivery.data.MyEntity;
import com.example.delivery.data.Param;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;

import static com.example.delivery.utils.Constants.KEY1;
import static com.example.delivery.utils.Constants.KEY2;

public class MainViewModel extends AndroidViewModel {
    MutableLiveData<List<MyEntity>> listLive=new MutableLiveData<>();
    MutableLiveData<List<Param>> section1Live=new MutableLiveData<>();
    MutableLiveData<List<Param>> section2Live=new MutableLiveData<>();
    private MainRepositoriy repo=new MainRepositoriy();

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public void getAllData(){
        getList();
        getPArams();
    }
    private void getList(){
        repo.dataList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((@io.reactivex.annotations.NonNull List<MyEntity> myEntities)->{
                    listLive.setValue(myEntities);
                });

    }
    private void getPArams(){
        repo.params().observeOn(AndroidSchedulers.mainThread())
                .subscribe((@io.reactivex.annotations.NonNull List<Param> list) ->{
                    setliveParams(list);
                });
    }
    private void setliveParams(List<Param> list){
        List<Param> forSection1=new ArrayList<>();
        List<Param> forSection2=new ArrayList<>();
        for (Param entity: list){
            switch (entity.getKeys()){
                case KEY1:
                    forSection1.add(entity);
                    break;
                case KEY2:
                    forSection2.add(entity);
                    break;
            }
        }
        section1Live.setValue(forSection1);
        section2Live.setValue(forSection2);
    }
}
