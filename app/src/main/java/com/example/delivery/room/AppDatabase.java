package com.example.delivery.room;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.delivery.data.Favorites;
import com.example.delivery.data.MyEntity;
import com.example.delivery.data.Param;

@Database(entities = {MyEntity.class, Param.class, Favorites.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MyDao daoFavorites ();
}
