package com.example.deliverykotlin

import com.example.deliverykotlin.components.menu.Param
import com.example.deliverykotlin.room.DaoMenu
import com.example.deliverykotlin.data.*

class SplashRepositoriy(val daoMenu: DaoMenu) {

    suspend fun loadRestEntities():List<MyEntity> {
        return getEntityList()
    }

    suspend fun  saveEntityList(entityList: List<MyEntity>) :Boolean{
        val list=daoMenu.saveEntityList(entityList)
        if (list!=null && list.size!=0){
            return true
        } else return  false
    }

    suspend fun  loadRestThirstParam():List<Brand>{
        return getBrandList()
    }

    suspend fun  saveThirstParam(param1List: List<Brand>) :Boolean{
        val list= daoMenu.saveThirstParam(param1List)
        if (list!=null && list.size!=0){
            return true
        } else return  false
    }

    suspend fun  loadRestSecondParam():List<Type>{
        return getTypeList()
    }

    suspend fun  saveSecondParam(param2List: List<Type>) :Boolean{
        val list= daoMenu.saveSecondParam(param2List)
        if (list!=null && list.size!=0){
            return true
        } else return  false
    }

    suspend fun loadBdEntityList():Boolean{
        val list= daoMenu.loadEntityList()
        if (list!=null && list.size!=0){
            return true
        } else return false
    }

    suspend fun loadBdThirstParam():Boolean{
        val list= daoMenu.loadThirstParamList()
        if (list!=null && list.size!=0){
            return true
        } else return false
    }

    suspend fun loadBdSecondParam():Boolean{
        val list= daoMenu.loadSecondParamList()
        if (list!=null && list.size!=0){
            return true
        } else return false
    }
}