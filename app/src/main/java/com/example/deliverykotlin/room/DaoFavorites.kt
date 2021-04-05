package com.example.deliverykotlin.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.deliverykotlin.data.Favorites
import com.example.deliverykotlin.data.MyEntity

@Dao
interface DaoFavorites {
    @Insert
    fun saveFavoritePosition(favorite: Favorites)

    @Query("SELECT * FROM myentity INNER JOIN favorites ON myentity.entityId=favorites.entity")
    fun getFavorites(): List<MyEntity>

    @Query("SELECT * FROM favorites WHERE favorites.entity=:id")
    fun getOneFavorite(id :Int):Favorites

    @Query("DELETE FROM favorites WHERE favorites.entity=:id")
    fun deleteOne(id: Int)

}