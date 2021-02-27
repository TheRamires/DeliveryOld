package com.example.delivery.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.delivery.data.MyEntity;

import java.util.List;

@Dao
public interface DaoFavorites {
    @Insert
    long saveFavorites (MyEntity myEntity);

    @Insert
    void saveList (MyEntity... myEntity);

    @Query("SELECT * FROM myentity")
    List<MyEntity> getFavorites();

    @Delete
    int deleteFavorite(MyEntity myEntity);

    @Query("SELECT * FROM myentity WHERE name=:name")
    MyEntity cheakPosition(String name);
}
