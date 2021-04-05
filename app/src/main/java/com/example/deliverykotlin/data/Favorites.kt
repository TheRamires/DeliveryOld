package com.example.deliverykotlin.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Favorites{
        @PrimaryKey(autoGenerate = true)
        var id:Int?=null
        var entity:Int?=null
                set(value) {
                        field=value
                }

}