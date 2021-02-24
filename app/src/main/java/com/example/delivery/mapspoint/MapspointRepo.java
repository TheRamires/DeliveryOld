package com.example.delivery.mapspoint;

import android.content.Context;

import androidx.databinding.ObservableField;

import com.google.android.gms.maps.GoogleMap;

public interface MapspointRepo {
    public void geopoint();
    public void googlemapsInit(GoogleMap mMap);
}
