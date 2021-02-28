package com.example.delivery;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;

public class LoadingLiveData {
    MediatorLiveData<Boolean> isLoaded=new MediatorLiveData<>();
    private boolean listIsLoaded;
    private boolean section1isLoaded;
    private boolean section2isLoaded;
}
