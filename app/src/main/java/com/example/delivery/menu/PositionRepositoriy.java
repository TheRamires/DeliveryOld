package com.example.delivery.menu;

import androidx.lifecycle.MutableLiveData;

import com.example.delivery.App;
import com.example.delivery.Loger;
import com.example.delivery.data.MyEntity;
import com.example.delivery.room.AppDatabase;
import com.example.delivery.room.DaoMenu;

import io.reactivex.Maybe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

public class PositionRepositoriy {
    private AppDatabase db= App.getInstance().getDatabase();
    public DaoMenu dao=db.daoMenu();

    public Maybe<MyEntity> getPositionFromBd( int id) {
        return dao.getPosition(id)
                .subscribeOn(Schedulers.io());
    }
}
