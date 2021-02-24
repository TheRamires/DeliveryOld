package com.example.delivery.data;

public class Entity {
    private String img;
    private String name;
    private String description;
    private String price;
    private String param1;
    private String param2;

    public Entity(String img,String name,String description,String price,String param1, String param2 ){
        this.img=img;
        this.name=name;
        this.description=description;
        this.price=price;
        this.param1=param1;
        this.param2=param2;

    }

    public void setImg(String img){
        this.img=img;
    }
    public String getImg(){
        return img;
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
