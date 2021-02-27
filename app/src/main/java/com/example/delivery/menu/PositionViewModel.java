package com.example.delivery.menu;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.delivery.Loger;
import com.example.delivery.data.MyEntity;

public class PositionViewModel extends ViewModel {
    MutableLiveData<MyEntity> positionLive=new MutableLiveData<>();
    private PositionRepositoriy repo=new PositionRepositoriy();

    public void getPosition(int id){
        repo.getPositionFromBd(positionLive, id);
    }
}
