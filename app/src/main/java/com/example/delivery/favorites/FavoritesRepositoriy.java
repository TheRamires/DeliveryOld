package com.example.delivery.favorites;

import androidx.lifecycle.MutableLiveData;

import com.example.delivery.App;
import com.example.delivery.data.MyEntity;
import com.example.delivery.room.AppDatabase;
import com.example.delivery.room.DaoFavorites;

import java.util.List;

public class FavoritesRepositoriy {
    private AppDatabase db= App.getInstance().getDatabase();
    public DaoFavorites dao=db.daoFavorites();

    public void loadFavorites(MutableLiveData<List<MyEntity>> favoritesLive){
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
                dao.saveFavorites(entity);
            }
        }).start();
    }
    public void delete(MyEntity myEntity){
        new Thread(()-> {
            int number=dao.deleteFavorite(myEntity);
        }).start();
    }
}
