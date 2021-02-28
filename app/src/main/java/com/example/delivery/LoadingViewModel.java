package com.example.delivery;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoadingViewModel extends ViewModel {
    private MutableLiveData<Boolean> listIsLoaded=new MutableLiveData<>(false);
    private MutableLiveData<Boolean> paramsIsLoaded=new MutableLiveData<>(false);
    public MediatorLiveData<Boolean> isLoaded=new MediatorLiveData<>();
    private LoadingRepositoriy repo=new LoadingRepositoriy(listIsLoaded, paramsIsLoaded);

    public void isLoaded(){
        isLoaded.addSource(listIsLoaded, (Boolean aBoolean)-> {
            cheakBooleans();
        });
        isLoaded.addSource(paramsIsLoaded,  (Boolean aBoolean)-> {
            cheakBooleans();

        });
    }
    private void cheakBooleans(){
        if (listIsLoaded.getValue()==true & paramsIsLoaded.getValue()==true){
            isLoaded.setValue(true);
        }
    }

    public void getAllData(){
        isLoaded();
        repo.dataList();
        repo.params();
    }
}
