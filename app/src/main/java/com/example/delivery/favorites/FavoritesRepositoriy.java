package com.example.delivery.favorites;

import androidx.lifecycle.MutableLiveData;

import com.example.delivery.App;
import com.example.delivery.Loger;
import com.example.delivery.data.Favorites;
import com.example.delivery.data.MyEntity;
import com.example.delivery.room.AppDatabase;
import com.example.delivery.room.DaoMenu;

import java.util.List;

import io.reactivex.MaybeObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class FavoritesRepositoriy {
    private AppDatabase db= App.getInstance().getDatabase();
    public DaoMenu dao=db.daoMenu();
    private MutableLiveData<List<MyEntity>> favoritesLive;

    public FavoritesRepositoriy(MutableLiveData<List<MyEntity>> favoritesLive){
        this.favoritesLive=favoritesLive;
    }
    public void refreshList(){
        Loger.log("favoritesDb");
        dao.getFavorites()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<MyEntity>>() {
                    @Override
                    public void accept(@NonNull List<MyEntity> myEntities) throws Exception {
                        Loger.log("favoritesDb myEntities.size() " + myEntities.size());
                        favoritesLive.setValue(myEntities);

                    }
                });
    }
    public void deleteOne(int entityId){
        dao.deleteFavoriteOne(entityId)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer integer) throws Exception {
                        if (integer!=0){
                            refreshList();
                        }
                    }
                });
    }

    public void cheakOne(int entityId) {
        Loger.log("addOne");
        dao.cheakOne(entityId)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new MaybeObserver<Favorites>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Loger.log("onSubscribe" + d);
                    }

                    @Override
                    public void onSuccess(Favorites favorites) {
                        deleteOne(entityId);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Loger.log("onComplete "+entityId);
                        long isSaved=dao.saveFavoriteOne(new Favorites(entityId));
                        Loger.log("isSaved "+isSaved);

                    }
                });
    }

}
