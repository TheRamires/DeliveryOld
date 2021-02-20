package com.example.delivery.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.delivery.data.RestaurantsRepo;
import com.example.delivery.data.RestaurantsRepositoriy;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

public class RestaurantsViewModel extends ViewModel {

    private RestaurantsRepo repo=new RestaurantsRepositoriy();
    MutableLiveData<SupportMapFragment> initMapTrue=new MutableLiveData<>();

    public void getGeopoint(){
        repo.geopoint();
    }
    public void getMaps(GoogleMap mMap){
        repo.googlemapsInit(mMap, initMapTrue);
    }
}
