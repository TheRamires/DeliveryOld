package com.example.delivery.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.lifecycle.MutableLiveData;

import com.example.delivery.data.Entity;
import com.example.delivery.data.TestData;

import java.util.List;

public class MenuRepositoriy {
    private TestData testData=new TestData();

    public void requestData(MutableLiveData<List<Entity>> listLive){
        //test
        listLive.setValue(testData.data());
    }
    public void requestParams1(MutableLiveData<List<String>> section1Live){
        section1Live.setValue(testData.section1Drawables());
    }
}
