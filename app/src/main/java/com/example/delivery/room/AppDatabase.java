package com.example.delivery.room;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.delivery.data.MyEntity;

@Database(entities = {MyEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DaoFavorites daoFavorites ();
}
