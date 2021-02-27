package com.example.delivery.favorites;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.delivery.data.MyEntity;

import java.util.List;

public class FavoritesViewModel extends ViewModel {
    MutableLiveData<List<MyEntity>> favoritesLive=new MutableLiveData<>();

    FavoritesRepositoriy repo=new FavoritesRepositoriy();
}
