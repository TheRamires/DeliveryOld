package com.example.deliverykotlin

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SplashViewModel(val repo: SplashRepositoriy) : ViewModel() {
    var entitiesSaved =false
    var thirstParamsSaved=false
    var secondParamsSaved=false
    var splashCompleted=MediatorLiveData<Boolean>()

    fun entityList(){
        viewModelScope.launch(Dispatchers.IO) {
            when(repo.loadBdEntityList()){
                true->{ entitiesSaved=true; cheak(); return@launch }
                false->{
                    val list=repo.loadRestEntities()
                    val saved=repo.saveEntityList(list)
                    if (saved==true){ entitiesSaved=true; cheak(); return@launch }
                }
            }
        }
    }

    fun firstParamList(){
        viewModelScope.launch(Dispatchers.IO) {
            when(repo.loadBdThirstParam()==true){
                true->{ thirstParamsSaved=true; cheak(); return@launch   }
                false->{
                    val list=repo.loadRestThirstParam()
                    val saved=repo.saveThirstParam(list)
                    if (saved==true){ thirstParamsSaved=true; cheak(); return@launch  }
                }
            }
        }
    }

    fun secondParamList(){
        viewModelScope.launch(Dispatchers.IO) {
            when(repo.loadBdSecondParam()==true){
                true->{ secondParamsSaved=true; cheak(); return@launch  }
                false->{
                    val list=repo.loadRestSecondParam()
                    val saved=repo.saveSecondParam(list)
                    if (saved==true){ secondParamsSaved=true; cheak(); return@launch }
                }
            }
        }
    }

    fun cheak(){
        if (entitiesSaved ==true && thirstParamsSaved ==true && secondParamsSaved==true ){
            splashCompleted.postValue(true)
        }
    }
}