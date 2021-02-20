package com.example.delivery.data;

import androidx.lifecycle.MutableLiveData;

import com.example.delivery.Loger;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class RestaurantsRepositoriy implements RestaurantsRepo {
    private Geopoint geopoint=new Geopoint();
    private GoogleMap mMap;

    @Override
    public void geopoint() {
        geopoint.daterminate();
    }

    @Override
    public void googlemapsInit(GoogleMap mMap, MutableLiveData<SupportMapFragment> initMapTrue) {
        

    }

    private void init(GoogleMap mMap) {
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

            @Override
            public void onMapClick(LatLng latLng) {
                Loger.log("lat "+latLng.latitude + ", lon " + latLng.longitude);
            }
        });

        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {

            @Override
            public void onMapLongClick(LatLng latLng) {
                Loger.log("lat "+latLng.latitude + ", lon" + latLng.longitude);
            }
        });

        mMap.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener() {

            @Override
            public void onCameraChange(CameraPosition camera) {
                Loger.log("onCameraChange: " + camera.target.latitude + "," + camera.target.longitude);
            }
        });
    }
}
