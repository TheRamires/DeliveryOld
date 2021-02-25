package com.example.delivery.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.lifecycle.MutableLiveData;

import com.example.delivery.data.Entity;
import com.example.delivery.data.Param;
import com.example.delivery.data.TestData;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MenuRepositoriy {
    private TestData testData=new TestData();

    public void requestData(MutableLiveData<List<Entity>> listLive){
        List<Entity> list=testData.data();
        Collections.sort(list, (Entity o1, Entity o2)-> {
                return o1.getBrand().compareTo(o2.getBrand());
        });
        listLive.setValue(list);
    }
    public void requestParams1(MutableLiveData<List<Param>> section1Live){
        section1Live.setValue(testData.section1Drawables());
    }
    public void requestParam2(MutableLiveData<List<Param>> section2Live){
        section2Live.setValue(testData.section2());
    }
}
