package com.example.delivery;

import androidx.lifecycle.MutableLiveData;

import com.example.delivery.data.MyEntity;
import com.example.delivery.data.Param;
import com.example.delivery.data.TestData;
import com.example.delivery.room.AppDatabase;
import com.example.delivery.room.DaoBase;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
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


    public Maybe<List<MyEntity>> dataList(){
        return dao.loadList()
                .subscribeOn(Schedulers.io());
    }

    public Maybe<long[]> requestListApi(){
        return  testData.data()
                .subscribeOn(Schedulers.io())
                .map((@NonNull List<MyEntity> entities) -> {
                        return dao.saveList(entities);
                });
    }
    public Maybe<List<Param>> params(){
        return dao.loadParam()
                .subscribeOn(Schedulers.io());
    }
    public Flowable<long[]> requestParamsApi(){
        return Single.merge(testData.section1Drawables(), testData.section2())
                .subscribeOn(Schedulers.io())
                .map((@NonNull List<Param> list)->{
                        return dao.saveParams(list);
                });
    }
}
