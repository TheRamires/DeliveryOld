package com.example.delivery.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MyEntity {
    @PrimaryKey (autoGenerate = true)
    private int id;
    private String img;
    private String brand;
    private String name;
    private String description;
    private String price;
    private String param1;
    private String param2;

    public MyEntity(String brand, String img, String name, String description, String param1, String price){
        this.img=img;
        this.brand=brand;
        this.name=name;
        this.description=description;
        this.price=price;
        this.param1=param1;

    }
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }
    public void setImg(String img){
        this.img=img;
    }
    public String getImg(){
        return img;
    }
    public void setBrand(String brand) {
        this.brand=brand;
    }
    public String getBrand(){
        return brand;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public String getDescription(){
        return description;
    }
    public void setPrice(String price){
        this.price=price;
    }
    public String getPrice(){
        return price;
    }
    public void setParam1(String param1){
        this.param1=param1;
    }
    public String getParam1(){
        return param1;
    }
    public void setParam2(String param2){
        this.param2=param2;
    }
    public String getParam2(){
        return param2;
    }
}
