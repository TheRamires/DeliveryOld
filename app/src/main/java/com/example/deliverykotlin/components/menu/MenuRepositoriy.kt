package com.example.deliverykotlin.components.menu

import com.example.deliverykotlin.Loger
import com.example.deliverykotlin.data.Brand
import com.example.deliverykotlin.data.MyEntity
import com.example.deliverykotlin.data.Type
import com.example.deliverykotlin.room.DaoMenu

class MenuRepositoriy(val daoMenu: DaoMenu) {

    suspend fun loadEntities():List<MyEntity>{
        return daoMenu.loadEntityList()
    }
    suspend fun loadThirstParams():List<Brand>{
        return daoMenu.loadThirstParamList()
    }
    suspend fun loadSecondParams():List<Type>{
        return daoMenu.loadSecondParamList()
    }
}