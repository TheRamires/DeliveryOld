package com.example.delivery.favorites;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.delivery.data.MyEntity;

import java.util.List;

public class FavoritesViewModel extends ViewModel {
    MutableLiveData<List<MyEntity>> favoritesLive=new MutableLiveData<>();

    FavoritesRepositoriy repo=new FavoritesRepositoriy();

    public void getListFavorites(){
        repo.loadFavorites(favoritesLive);
    }

    public void cheakPosition(MyEntity entity){
        repo.cheakPosition(entity);
    }
    public void deletePosition(MyEntity entity){
        repo.delete(entity);
        new Thread(()-> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            getListFavorites();
        }).start();
    }
}
