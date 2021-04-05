package com.example.deliverykotlin.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Type (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name:String
)