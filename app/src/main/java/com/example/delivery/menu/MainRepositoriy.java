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

import io.reactivex.Maybe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

import static com.example.delivery.utils.Constants.KEY1;
import static com.example.delivery.utils.Constants.KEY2;


public class MainRepositoriy {
    private AppDatabase db= App.getInstance().getDatabase();
    public DaoBase dao=db.daoBase();
    private TestData testData=new TestData();

    public Maybe<List<MyEntity>> dataList(){
        return dao.loadList()
        .subscribeOn(Schedulers.io());
    }
    public Maybe<List<Param>> params(){
        return dao.loadParam()
                .subscribeOn(Schedulers.io());
    }
}
