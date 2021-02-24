package com.example.delivery.data;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.databinding.ObservableField;

import com.example.delivery.Loger;

public class Geopoint {
    private LocationManager locationManager;
    public Context context;
    private String context2 = Context.LOCATION_SERVICE;

    public Geopoint (Context context){
        this.context=context;

    }

    public void daterminate() {

        locationManager = (LocationManager) context.getSystemService(context2);
        LocationListener locationListener = new MyLocationListener();

        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Toast.makeText(context, "no granted", Toast.LENGTH_SHORT).show();
            return;
        }

        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000*10, 100000, locationListener);
    }

    class MyLocationListener implements LocationListener {

        @Override
        public void onLocationChanged(Location loc) {
            double lat=loc.getLatitude();
            double lon=loc.getLongitude();
            if(loc!=null) {
                Loger.log("GEOPOINT" + "lat " + lat + ", lon" + lon);
                Toast.makeText(context, "GEOPOINT" + "lat " + lat + ", lon" + lon, Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onProviderDisabled(String provider) {
            context.startActivity(new Intent(
                    android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
            Toast.makeText(context, "No internet", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onProviderEnabled(String provider) {}

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {}
    }
}