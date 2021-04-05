package com.example.deliverykotlin.components.favorites

import com.example.deliverykotlin.Loger
import com.example.deliverykotlin.data.Favorites
import com.example.deliverykotlin.data.MyEntity
import com.example.deliverykotlin.room.DaoFavorites

class FavoritesRepositoriy(val daoFavorites: DaoFavorites) {

    suspend fun loadFavorites(): List<MyEntity>{
        Loger.message(daoFavorites.getFavorites().size.toString()+" ☺ loadFavorites")
        return daoFavorites.getFavorites()
    }
    suspend fun saveOne(favorite: Favorites){
        daoFavorites.saveFavoritePosition(favorite)
    }
    suspend fun loadOne(id: Int): Boolean {
        val one=daoFavorites?.getOneFavorite(id)
        if (one ==null || one.id==0 ){
            return false
        }else return true
    }
    suspend fun deleteOne(id:Int){
        daoFavorites.deleteOne(id)
    }
}