package com.example.delivery.favorites;

import androidx.lifecycle.MutableLiveData;

import com.example.delivery.App;
import com.example.delivery.Loger;
import com.example.delivery.data.MyEntity;
import com.example.delivery.room.AppDatabase;
import com.example.delivery.room.DaoFavorites;

import java.util.List;
import java.util.Observable;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class FavoritesRepositoriy {
    private AppDatabase db= App.getInstance().getDatabase();
    public DaoFavorites dao=db.daoFavorites();
    MutableLiveData<List<MyEntity>> favoritesLive;

    public void loadFavorites(MutableLiveData<List<MyEntity>> favoritesLive){
        this.favoritesLive=favoritesLive;
        new Thread(() ->{
                favoritesLive.postValue(dao.getFavorites());
        }).start();
    }
    public void cheakPosition(MyEntity entity){/*
        dao.deleteFavorite(entity)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer integer) throws Exception {
                        Loger.log("•••••• "+integer);
                        if (integer==0){
                            dao.saveFavorites(entity);
                        }
                    }
                });*/


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



        /*new Thread(()-> {
            int number=dao.deleteFavorite(myEntity);
            Loger.log("delete is done, int = "+number);
            if (number!=0){
                loadFavorites(favoritesLive);
            }
        }).start();*/
    }
}
