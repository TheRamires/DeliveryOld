package com.example.delivery.menu;

import androidx.lifecycle.MutableLiveData;

import com.example.delivery.App;
import com.example.delivery.Loger;
import com.example.delivery.data.MyEntity;
import com.example.delivery.room.AppDatabase;
import com.example.delivery.room.MyDao;

import io.reactivex.MaybeObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class PositionRepositoriy {
    private AppDatabase db= App.getInstance().getDatabase();
    public MyDao dao=db.daoFavorites();

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
