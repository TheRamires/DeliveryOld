package com.example.delivery.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Param {
    @PrimaryKey (autoGenerate = true)
    private int id;
    private String keys;
    private String name;
    private String img;

    public Param(String keys, String name, String img){
        this.keys=keys;
        this.name=name;
        this.img=img;
    }
    public void setId(int id) {this.id=id;}
    public int getId(){return  id;}

    public void setKeys(String keys){
        this.keys=keys;
    }
    public String getKeys(){
        return keys;
    }

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setImg(String img){
        this.img=img;
    }
    public String getImg(){
        return img;
    }
}