package com.example.deliverykotlin.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Brand(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name:String
    //val img: String,
)