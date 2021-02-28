package com.example.delivery.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.delivery.data.MyEntity;
import com.example.delivery.data.Param;

import java.util.List;

import io.reactivex.Maybe;

@Dao
public interface DaoBase {
    @Insert
    long[] saveList(List<MyEntity> list);

    @Query("SELECT * FROM myentity")
    Maybe<List<MyEntity>> loadList();

    @Insert
    long[] saveParams(List<Param> list);

    @Query("SELECT * FROM Param")
    Maybe<List<Param>> loadParam();
}

