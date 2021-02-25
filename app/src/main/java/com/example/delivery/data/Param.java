package com.example.delivery.data;

public class Param {
    private String key;
    private String name;
    private String img;

    public Param(Key key, String name, String img){
        this.key=key.name();
        this.name=name;
        this.img=img;
    }

    public void setKey(Key key){
        this.key=key.name();
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