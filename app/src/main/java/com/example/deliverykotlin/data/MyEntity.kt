package com.example.deliverykotlin.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MyEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="entityId")
    val id: Int,
    //val img: String,
    val brand: String,
    val name: String,
    val description: String,
    val price: String,
    val type:String,
){
    var counter:Int=0
        set(value) {
            if (value<=0){
                field=0
            } else {
                field=value
            }
        }
        get(){
            return field
        }

    var counterVisible:Boolean=false

    fun addPostion(): Boolean{
        if (counter==0){
            counter++
            return  true
        } else return  false
    }

    fun plusPosition(): Boolean{
        counter++
        return true
    }

    fun minusPosition():Boolean{
        if (counter>=1){
            counter--
            return true
        }else return false
    }
}