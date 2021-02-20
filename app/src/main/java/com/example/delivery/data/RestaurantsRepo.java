package com.example.delivery.data;

import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

public interface RestaurantsRepo {
    public void geopoint();
    public void googlemapsInit(GoogleMap mMap, MutableLiveData<SupportMapFragment> initMapTrue);
}
