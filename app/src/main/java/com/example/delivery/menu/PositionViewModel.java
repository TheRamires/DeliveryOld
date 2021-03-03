package com.example.delivery.menu;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.delivery.Loger;
import com.example.delivery.data.MyEntity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;

public class PositionViewModel extends ViewModel {
    MutableLiveData<MyEntity> positionLive=new MutableLiveData<>();
    private PositionRepositoriy repo=new PositionRepositoriy();

    public void getPosition(int id){
        repo.getPositionFromBd( id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((@NonNull MyEntity myEntity) -> {
                    positionLive.setValue(myEntity);
                });
    }
}
