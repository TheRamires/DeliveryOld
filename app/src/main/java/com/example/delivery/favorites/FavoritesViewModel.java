package com.example.delivery.favorites;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.delivery.Loger;
import com.example.delivery.data.Favorites;
import com.example.delivery.data.MyEntity;

import java.util.List;

import io.reactivex.MaybeObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class FavoritesViewModel extends ViewModel {
    MutableLiveData<List<MyEntity>> favoritesLive=new MutableLiveData<>();

    FavoritesRepositoriy repo=new FavoritesRepositoriy();

    public void getFavorites(){
        repo.refreshList()
                .subscribe((@NonNull List<MyEntity> myEntities)->{
                        Loger.log("favoritesDb myEntities.size() " + myEntities.size());
                        favoritesLive.setValue(myEntities);
                });
    }
    public void deleteOne(int entityId){
        repo.deleteOne(entityId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((@NonNull Integer integer) ->{
                        if (integer!=0){
                            getFavorites();
                    }
                });
    }
    public void onePosition(int entityId){
        repo.cheakOne(entityId)
                .observeOn(AndroidSchedulers.mainThread())
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
                        saveOne(entityId);

                    }
                });
    }
    public void saveOne(int entityId ){
        repo.saveOne(entityId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((@NonNull Long aLong)-> {
                        Loger.log("isSaved complete "+aLong);

                });
    }
}
