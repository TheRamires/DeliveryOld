package com.example.delivery.favorites;

import androidx.lifecycle.MutableLiveData;

import com.example.delivery.App;
import com.example.delivery.Loger;
import com.example.delivery.data.MyEntity;
import com.example.delivery.room.AppDatabase;
import com.example.delivery.room.MyDao;

import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

public class FavoritesRepositoriy {
    private AppDatabase db= App.getInstance().getDatabase();
    public MyDao dao=db.daoFavorites();
    MutableLiveData<List<MyEntity>> favoritesLive;
/*
    public void loadFavorites(MutableLiveData<List<MyEntity>> favoritesLive){
        this.favoritesLive=favoritesLive;
        new Thread(() ->{
                favoritesLive.postValue(dao.getFavorites());
        }).start();
    }
    public void cheakPosition(MyEntity entity){


        new Thread(()->{
            try {
                MyEntity entityBd;
                entityBd=dao.cheakPosition(entity.getName());
                dao.deleteFavorite(entityBd);

            }catch (Throwable t){
                long save=dao.saveFavorites(entity);
            }
        }).start();
    }
    public void delete(MyEntity myEntity){

        dao.deleteFavorite(myEntity)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe((@NonNull Integer integer)-> {
                    Loger.log("•••••• "+integer);
                    loadFavorites(favoritesLive);
                });

*/

}
