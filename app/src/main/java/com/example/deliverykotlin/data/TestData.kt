package com.example.deliverykotlin.data

import java.util.*
import kotlin.collections.ArrayList

fun getEntityList(): MutableList<MyEntity>{
    var list: MutableList<MyEntity> = ArrayList()
    var id:Int=1
    for (i in id..id+3){
        var entity=MyEntity(
            i,
            BrandOfCar.FERRARI.name,
            "FERRARI model $i",
            "good model",
            "$i 000 000",
            TypeOfCar.SPORTCAR.name
        )
        list.add(entity)
    }
    id=id+1+3
    for (i in id..id+2){
        var entity=MyEntity(
            i,
            BrandOfCar.FERRARI.name,
            "FERRARI model $i",
            "good model",
            "$i 000 000",
            TypeOfCar.MUSLECAR.name
        )
        list.add(entity)
    }
    id=id+1+2
    for (i in id..id+1){
        var entity=MyEntity(
            i,
            BrandOfCar.FERRARI.name,
            "FERRARI model $i",
            "good model",
            "$i 000 000",
            TypeOfCar.RETRO.name
        )
        list.add(entity)
    }
    id=id+1+1
    for (i in id..id+2){
        var entity=MyEntity(
            i, BrandOfCar.FORD.name, "FORD model $i", "good model", "$i 000 000", TypeOfCar.SPORTCAR.name
        )
        list.add(entity)
    }
    id=id+1+2
    for (i in id..id+4){
        var entity=MyEntity(
            i,
            BrandOfCar.FORD.name,
            "FORD model $i",
            "good model",
            "$i 000 000",
            TypeOfCar.MUSLECAR.name
        )
        list.add(entity)
    }
    id=id+1+4
    for (i in id..id+6){
        var entity=MyEntity(
            i,
            BrandOfCar.LAMBORGHINI.name,
            "LAMBORGHINI model $i",
            "good model",
            "$i 000 000",
            TypeOfCar.SPORTCAR.name
        )
        list.add(entity)
    }

    return list
}
fun getBrandList(): MutableList<Brand>{
    var list:MutableList<Brand> = ArrayList()
    list.add(Brand(1,BrandOfCar.FERRARI.name))
    list.add(Brand(2,BrandOfCar.FORD.name))
    list.add(Brand(3,BrandOfCar.LAMBORGHINI.name))
    return list
}
fun getTypeList(): MutableList<Type>{
    var list: MutableList<Type> = ArrayList()
    list.add(Type(1,TypeOfCar.SPORTCAR.name))
    list.add(Type(2,TypeOfCar.MUSLECAR.name))
    list.add(Type(3,TypeOfCar.RETRO.name))
    return list
}


internal enum class BrandOfCar {
    FERRARI, FORD, LAMBORGHINI
}

internal enum class TypeOfCar {
    SPORTCAR, MUSLECAR, RETRO
}
