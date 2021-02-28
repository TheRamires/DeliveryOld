package com.example.delivery;

import androidx.lifecycle.MutableLiveData;

import com.example.delivery.data.MyEntity;
import com.example.delivery.data.Param;
import com.example.delivery.data.TestData;
import com.example.delivery.room.AppDatabase;
import com.example.delivery.room.DaoBase;
import com.example.delivery.room.DaoMenu;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;


public class LoadingRepositoriy {
    private MutableLiveData<Boolean> listIsLoaded;
    private MutableLiveData<Boolean> paramsIsLoaded;
    private AppDatabase db= App.getInstance().getDatabase();
    public DaoBase dao=db.daoBase();
    private TestData testData=new TestData();

    public LoadingRepositoriy(MutableLiveData<Boolean> listIsLoaded,
                              MutableLiveData<Boolean> paramsIsLoaded){
        this.listIsLoaded=listIsLoaded;
        this.paramsIsLoaded=paramsIsLoaded;
    }

    public void dataList(){
        dao.loadList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((@NonNull List<MyEntity> myEntities)->{
                    if (myEntities.size()==0) {
                        requestListApi();
                    } else listIsLoaded.postValue(true);
                });
    }

    private void requestListApi(){
        testData.data()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe((@NonNull List<MyEntity> myEntities)->{
                    long[] isSave=dao.saveList(myEntities);
                    if (isSave.length!=0){
                        listIsLoaded.postValue(true);
                    }
                });
    }
    public void params(){
        dao.loadParam()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((@NonNull List<Param> list) ->{
                    if (list.size()==0){
                        Loger.log("list.size()==0");
                        requestParamsApi();
                    }else {
                        Loger.log("sectionLive.setValue(list)");
                        paramsIsLoaded.postValue(true);
                    }
                });
    }
    public void requestParamsApi(){
        Single.merge(testData.section1Drawables(), testData.section2())
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe((@NonNull List<Param> list) ->{
                    long [] saved=dao.saveParams(list);
                    if (saved.length!=0){
                        paramsIsLoaded.postValue(true);
                    }
                });
    }
}
