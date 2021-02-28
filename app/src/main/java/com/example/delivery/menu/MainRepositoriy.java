package com.example.delivery.menu;

import androidx.lifecycle.MutableLiveData;
import com.example.delivery.App;
import com.example.delivery.data.MyEntity;
import com.example.delivery.data.Param;
import com.example.delivery.data.TestData;
import com.example.delivery.room.AppDatabase;
import com.example.delivery.room.DaoBase;
import com.example.delivery.room.DaoMenu;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

import static com.example.delivery.utils.Constants.KEY1;
import static com.example.delivery.utils.Constants.KEY2;


public class MainRepositoriy {
    private AppDatabase db= App.getInstance().getDatabase();
    public DaoBase dao=db.daoBase();
    private TestData testData=new TestData();
    MutableLiveData<List<Param>> section1Live;
    MutableLiveData<List<Param>> section2Live;
    MutableLiveData<List<MyEntity>> listLive;

    public MainRepositoriy( MutableLiveData<List<Param>> section1Live,
                            MutableLiveData<List<Param>> section2Live,
                            MutableLiveData<List<MyEntity>> listLive){
        this.section1Live=section1Live;
        this.section2Live=section2Live;
        this.listLive=listLive;
    }
    public void dataList(){
        dao.loadList()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe((@NonNull List<MyEntity> myEntities)->{
            listLive.setValue(myEntities);
        });
    }
    public void params(){
        dao.loadParam()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((@NonNull List<Param> list) ->{
                    setliveParams(list);
                });
    }
    private void setliveParams(List<Param> list){
        List<Param> forSection1=new ArrayList<>();
        List<Param> forSection2=new ArrayList<>();
        for (Param entity: list){
            switch (entity.getKeys()){
                case KEY1:
                    forSection1.add(entity);
                    break;
                case KEY2:
                    forSection2.add(entity);
                    break;
            }
        }
        section1Live.setValue(forSection1);
        section2Live.setValue(forSection2);
    }
}
