package com.example.delivery.mapspoint;
import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.delivery.data.Geopoint;
import com.example.delivery.mapspoint.MapspointRepo;
import com.example.delivery.mapspoint.MapspointRepositoriy;
import com.google.android.gms.maps.GoogleMap;

public class MapspointViewModel extends AndroidViewModel {

    private Context context;
    private MapspointRepo repo;


    public MapspointViewModel(@NonNull Application application) {
        super(application);
        context=getApplication().getApplicationContext();
        repo=new MapspointRepositoriy(getApplication().getApplicationContext());
    }

    public void getGeopoint(){
        repo.geopoint();
    }
    public void getMaps(GoogleMap mMap){
        repo.googlemapsInit(mMap);
    }
}
