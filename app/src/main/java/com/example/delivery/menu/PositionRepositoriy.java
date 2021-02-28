package com.example.delivery.menu;

import androidx.lifecycle.MutableLiveData;

import com.example.delivery.App;
import com.example.delivery.Loger;
import com.example.delivery.data.MyEntity;
import com.example.delivery.room.AppDatabase;
import com.example.delivery.room.DaoMenu;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

public class PositionRepositoriy {
    private AppDatabase db= App.getInstance().getDatabase();
    public DaoMenu dao=db.daoMenu();

    public void getPositionFromBd(MutableLiveData<MyEntity> liveData, int id) {
        Loger.log("getPositionFromBd from id= "+id);
        dao.getPosition(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((@NonNull MyEntity myEntity) -> {
                        liveData.setValue(myEntity);
                });
    }
}
