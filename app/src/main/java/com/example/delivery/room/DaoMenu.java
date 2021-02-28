package com.example.delivery.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.delivery.data.Favorites;
import com.example.delivery.data.MyEntity;
import com.example.delivery.data.Param;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

@Dao
public interface DaoMenu {
    @Query("SELECT *FROM myentity WHERE id=:id")
    Maybe<MyEntity> getPosition(int id);


    @Query("SELECT * FROM myentity INNER JOIN favorites WHERE myentity.id=favorites.entityId ")
    Maybe<List<MyEntity>> getFavorites();

    @Query("SELECT * FROM favorites")
    Maybe<List<Favorites>> getlistFavorites();

    @Insert
    long saveFavoriteOne(Favorites entityId);

    @Delete
    int deleteFavoriteOne(Favorites favorites);

    @Query("DELETE FROM favorites WHERE entityId=:entityId")
    Single<Integer> deleteFavoriteOne(int entityId);

    @Query("SELECT * FROM favorites WHERE entityId=:entityId")
    Maybe<Favorites> cheakOne(int  entityId);
}
