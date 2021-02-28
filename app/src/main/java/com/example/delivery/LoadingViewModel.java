package com.example.delivery;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.delivery.data.MyEntity;
import com.example.delivery.data.Param;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

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
        cheakListDb();
        cheakParamDb();
    }
    private void cheakListDb(){
        repo.dataList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((@NonNull List<MyEntity> myEntities)->{
                    if (myEntities.size()==0) {
                        requestList();
                    } else listIsLoaded.postValue(true);
                });
    }
    private void requestList(){
        repo.requestListApi()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<long[]>() {
                    @Override
                    public void accept(@NonNull long[] isSaved) throws Exception {
                        if (isSaved.length!=0){
                            listIsLoaded.postValue(true);
                        }
                    }
                });
    }
    private void cheakParamDb(){
        repo.params()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((@NonNull List<Param> list) ->{
                    if (list.size()==0){
                        Loger.log("list.size()==0");
                        requestParams();
                    }else {
                        Loger.log("sectionLive.setValue(list)");
                        paramsIsLoaded.postValue(true);
                    }
                });
    }
    private void requestParams(){
        repo.requestParamsApi()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((@NonNull long[] isSaved) ->{
                    if (isSaved.length!=0){
                        paramsIsLoaded.postValue(true);
                    }
                });
    }
}
