package com.example.delivery.data;

public class Param {
    private String key;
    private String name;
    private String img;

    public Param(String key, String name, String img){
        this.key=key;
        this.name=name;
        this.img=img;
    }

    public void setKey(String key){
        this.key=key;
    }
    public String getKey (){
        return key;
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