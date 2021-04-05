package com.example.deliverykotlin.room

import androidx.annotation.NonNull
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.deliverykotlin.data.Brand
import com.example.deliverykotlin.data.MyEntity
import com.example.deliverykotlin.data.Type

@Dao
interface DaoMenu {

    @Insert
    fun saveEntityList(@NonNull entities:List<MyEntity>): Array<Long>

    @Insert
    fun saveThirstParam(@NonNull params: List<Brand>): Array<Long>

    @Insert
    fun saveSecondParam(@NonNull params: List<Type>): Array<Long>

    @Query("SELECT * FROM myentity")
    fun loadEntityList():List<MyEntity>

    @Query("SELECT * FROM brand")
    fun loadThirstParamList():List<Brand>

    @Query("SELECT * FROM type")
    fun loadSecondParamList():List<Type>

}