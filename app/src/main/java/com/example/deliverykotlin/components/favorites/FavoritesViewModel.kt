package com.example.deliverykotlin.components.favorites


import androidx.lifecycle.*
import com.example.deliverykotlin.Loger
import com.example.deliverykotlin.data.Favorites
import com.example.deliverykotlin.data.MyEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FavoritesViewModel (val repo:FavoritesRepositoriy):ViewModel() {
    var favoritesListLive=MutableLiveData<List<MyEntity>>()

    fun getFavoritesList(){
        GlobalScope.launch(Dispatchers.IO) {
            Loger.message("☺ "+"getFavoritesList")
            val list=repo.loadFavorites()
            favoritesListLive.postValue(list)
        }
    }
    fun clickFaforitePosition(entity: MyEntity?){
        GlobalScope.launch(Dispatchers.IO){
            val entityId=entity!!.id

            var favorite=Favorites()
            favorite.entity=entityId

            if (repo.loadOne(entityId)==true){
                deleteExactly(entityId)
            } else repo.saveOne(favorite)
        }
    }
    fun deleteExactly(entityId: Int){
        GlobalScope.launch(Dispatchers.IO) {
            repo.deleteOne(entityId)
        }
    }
}