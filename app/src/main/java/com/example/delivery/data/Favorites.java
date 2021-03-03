package com.example.delivery.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Favorites {
    @PrimaryKey
    private int entityId;
    public Favorites(int entityId){
        this.entityId=entityId;
    }

    public void setEntityId(int entityId){
        this.entityId=entityId;
    }
    public int getEntityId(){
        return entityId;
    }
}
