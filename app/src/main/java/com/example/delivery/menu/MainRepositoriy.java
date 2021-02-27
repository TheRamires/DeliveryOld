package com.example.delivery.menu;

import androidx.lifecycle.MutableLiveData;
import com.example.delivery.App;
import com.example.delivery.Loger;
import com.example.delivery.data.MyEntity;
import com.example.delivery.data.Param;
import com.example.delivery.data.TestData;
import com.example.delivery.room.AppDatabase;
import com.example.delivery.room.MyDao;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableMaybeObserver;
import io.reactivex.schedulers.Schedulers;

import static com.example.delivery.utils.Constants.KEY1;
import static com.example.delivery.utils.Constants.KEY2;


public class MainRepositoriy {
    private AppDatabase db= App.getInstance().getDatabase();
    public MyDao dao=db.daoFavorites();
    private TestData testData=new TestData();
    MutableLiveData<List<Param>> section1Live;
    MutableLiveData<List<Param>> section2Live;

    public MainRepositoriy( MutableLiveData<List<Param>> section1Live,
                            MutableLiveData<List<Param>> section2Live){
        this.section1Live=section1Live;
        this.section2Live=section2Live;
    }

    public void requestListApi(MutableLiveData<List<MyEntity>> listLive){
        testData.data()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe((@NonNull List<MyEntity> myEntities)->{
                        listLive.postValue(myEntities);
                        long[] isSave=dao.saveList(myEntities);
                });
      /*
        new Thread(() ->{
            //main list of position
            List<MyEntity> list=testData.data();
            dao.saveList(list);

            //sections
            List<Param> params1 =testData.section1Drawables();
            List<Param> params2 =testData.section2();

            dao.saveParam(params1);
            dao.saveParam(params2);

        }).start();*/
    }
    public void requestParamsApi(){
        Single.merge(testData.section1Drawables(), testData.section2())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((@NonNull List<Param> list) ->{
                    setliveParams(list);
                    Loger.log("requestParamsApi) "+list.size());
                });
    }


    /*
    public void loadDb(MutableLiveData<List<MyEntity>> listLive,
                       MutableLiveData<List<Param>> section1Live,
                       MutableLiveData<List<Param>> section2Live){
        new Thread(()->{
            listLive.postValue(dao.loadList());
            section1Live.postValue(dao.loadParam(KEY1));
            section2Live.postValue(dao.loadParam(KEY2));
        }).start();
    }*/
    public void dataList(MutableLiveData<List<MyEntity>> listLive){
        dao.loadList()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe((@NonNull List<MyEntity> myEntities)->{
            if (myEntities.size()==0) {
                requestListApi(listLive);
            } else listLive.setValue(myEntities);
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
                            setliveParams(list);
                        }
                });

    }
    private void setliveParams(List<Param> list){
        if (list.get(0).getKeys().equals(KEY1)){
            section1Live.postValue(list);
        } else if (list.get(0).getKeys().equals(KEY2)){
            section2Live.postValue(list);
        }
    }
}
