package com.example.deliverykotlin.components.menu

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deliverykotlin.Loger
import com.example.deliverykotlin.data.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MenuViewModel(val repo:MenuRepositoriy): ViewModel() {
    var param=MutableLiveData(Param.BRAND)
    var paramName= MutableLiveData<String>()
    var position: Int=0
    var listLive=MutableLiveData<MutableList<MyEntity>>()
    var brandLive=MutableLiveData<MutableList<Brand>>()
    var typeLive=MutableLiveData<MutableList<Type>>()
    var currentPostion=MutableLiveData<MyEntity>()

    fun getMenuList(){
        viewModelScope.launch(Dispatchers.IO) {
            var list=repo.loadEntities()
            Collections.sort(list, { o1, o2 -> o1.brand.compareTo(o2.brand) })
            listLive.postValue(list as MutableList<MyEntity>?)
        }
    }
    fun getSection1Live(){
        GlobalScope.launch(Dispatchers.IO){
            var list= repo.loadThirstParams()
            brandLive.postValue(list as MutableList<Brand>?)
        }
    }
    fun getSection2Live(){
        GlobalScope.launch(Dispatchers.IO){
            var list= repo.loadSecondParams()
            typeLive.postValue(list as MutableList<Type>)
        }
    }
    fun findPosition(list: MutableList<MyEntity>):Int{
        var i=0
        for (entity in list){
            if (paramName.value.equals(entity.brand)||
                paramName.value.equals(entity.type) ){
                return i
            }
            i++
        }
        return i
    }
    fun getPositionById(id: Int){
        //for example
        var list=listLive.value
        for (position in list!!){
            if (position.id==id){
                currentPostion.value=position
                break
            }
        }
    }
    fun sortListLive(param: Param){
        var comporator: Comparator<MyEntity>
        when(param){
            Param.BRAND -> comporator= Comparator<MyEntity> { o1, o2 -> o1.brand.compareTo(o2.brand) }
            Param.TYPE -> comporator= Comparator<MyEntity> { o1, o2 -> o1.type.compareTo(o2.type) }
        }

        var list=listLive.value
        Collections.sort(list, comporator)
        listLive.value=list
    }
}
enum class Param{
    BRAND, TYPE
}