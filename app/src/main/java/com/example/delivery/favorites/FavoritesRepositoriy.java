package com.example.delivery.favorites;

import androidx.lifecycle.MutableLiveData;

import com.example.delivery.App;
import com.example.delivery.Loger;
import com.example.delivery.data.Favorites;
import com.example.delivery.data.MyEntity;
import com.example.delivery.room.AppDatabase;
import com.example.delivery.room.DaoMenu;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class FavoritesRepositoriy {
    private AppDatabase db= App.getInstance().getDatabase();
    public DaoMenu dao=db.daoMenu();
    public Maybe<List<MyEntity>> refreshList(){
        return dao.getFavorites()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
    public Single<Integer> deleteOne(int entityId){
        return dao.deleteFavoriteOne(entityId)
                .subscribeOn(Schedulers.io());
    }

    public Maybe<Favorites> cheakOne(int entityId) {
         return dao.cheakOne(entityId)
                .subscribeOn(Schedulers.io());
    }
    public Single<Long> saveOne(int entityId){
        return dao.saveFavoriteOne(new Favorites(entityId))
                .subscribeOn(Schedulers.io());
    }
}
