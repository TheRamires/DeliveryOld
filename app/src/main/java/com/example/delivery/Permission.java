package com.example.delivery;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.delivery.mapspoint.MapspointViewModel;

import static com.example.delivery.utils.Constants.REQUEST_CODE_PERMISSION_FINE_LOCATION;

public class Permission {
    private MapspointViewModel viewModel;
    private Activity activity;
    private Context context;

    public Permission (MapspointViewModel viewModel, Activity activity, Context context){
        this.viewModel=viewModel;
        this.activity=activity;
        this.context=context;
    }

    public void permissionsResult(int requestCode, @NonNull int[] grantResults){
        switch (requestCode){
            case REQUEST_CODE_PERMISSION_FINE_LOCATION:if (grantResults.length > 0){
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Loger.log("PERMISSION_GRANTED");
                }else if (grantResults[0] == PackageManager.PERMISSION_DENIED){
                    // Should we show an explanation?
                    if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.ACCESS_FINE_LOCATION)) {
                        Loger.log("ACCESS_FINE_LOCATION");

                    }else{
                        //Never ask again selected, or device policy prohibits the app from having that permission.
                        //So, disable that feature, or fall back to another situation...
                    }
                }
            }
        }
    }

    public void requestPerm(){
        int permissionStatus = ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION);
        if (permissionStatus == PackageManager.PERMISSION_GRANTED) {
            Loger.log("PERMISSION_GRANTED");
        } else {
            ActivityCompat.requestPermissions(activity, new String[] {Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_CODE_PERMISSION_FINE_LOCATION);
        }
    }
}