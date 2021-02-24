package com.example.delivery.data;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.example.delivery.Loger;
import com.example.delivery.R;

import java.util.ArrayList;
import java.util.List;

public class TestData {
    public List<Entity> data(){
        Entity ferrari1=new Entity(Brand.FERRARI.name(), "ferrari_512_tr_1991","512 TR 1991","Скорость: 309 км/ч. \nМощность: 428 л.с.\nРазгон до 100: 4.8 сек.",Class.SPORTCAR.name(),"13200000");
        Entity ferrari2=new Entity(Brand.FERRARI.name(), "ferrari_enzo_2010","Enzo Gemballa MIG-U1 2010","Скорость: 350 км/ч.\nМощность: 700 л.с.\nРазгон до 100: 3.5 сек.", Class.SPORTCAR.name(),"99000000");
        Entity ferrari3=new Entity(Brand.FERRARI.name(), "ferrari_f40_1987","F40 1987","Скорость: 324 км/ч.\nМощность: 478 л.с.\nРазгон до 100: 4.1 сек.", Class.SPORTCAR.name(),"101640000");
        Entity ferrari4=new Entity(Brand.FERRARI.name(), "ferrari_f50_1995","F50 1995", "Скорость: 325 км/ч.\nМощность: 520 л.с.\nРазгон до 100: 3.9 сек.",Class.SPORTCAR.name(), "207240000");
        Entity ferrari5=new Entity(Brand.FERRARI.name(), "ferrari_f50_gt_1996","GT 1996", "Скорость: 378 км/ч.\nМощность: 750 л.с.\nРазгон до 100: 2.9 сек.",Class.SPORTCAR.name(), "105600000");
        Entity ferrari6=new Entity(Brand.FERRARI.name(), "ferrari_f512_m_1994","F512 M 1994", "Скорость: 315 км/ч.\nМощность: 440 л.с.\nРазгон до 100: 4.7 сек.",Class.SPORTCAR.name(), "16500000");
        Entity ferrari7=new Entity(Brand.FERRARI.name(), "ferrari_fxx_2005", "FXX 2005", "Скорость: 351 км/ч.\nМощность: 800 л.с.\nРазгон до 100: 3 сек.",Class.SPORTCAR.name(),"145200000");
        Entity ferrari8=new Entity(Brand.FERRARI.name(), "ferrari_p4_pininfarina_2006", "P4/5 Pininfarina 2006", "Скорость: 352 км/ч.\nМощность: 660 л.с.\nРазгон до 100: 3.2 сек.", Class.SPORTCAR.name(),"264000000");

        Entity ford1=new Entity(Brand.FORD.name(), "ford_falcon_2014","Falcon FPV GT F 2014", "Скорость: 297 км/ч.\nМощность: 477 л.с.\nРазгон до 100: 4.7 сек.",Class.MUSLECAR.name(), "3960000");
        Entity ford2=new Entity(Brand.FORD.name(), "ford_falcon_fpv_gt_cobra_2007", "Ford Falcon FPV GT Cobra R-spec 2007", "Скорость: 276 км/ч.\nМощность: 411 л.с.\nРазгон до 100: 5.4 сек.",Class.SPORTCAR.name(), "11220000");
        Entity ford3=new Entity(Brand.FORD.name(), "ford_gt_2017","GT 2017", "Скорость: 348 км/ч.\nМощность: 655 л.с.\nРазгон до 100: 3.1 сек.\nДизайн: 10", Class.SPORTCAR.name(),"3960000");
        Entity ford4=new Entity(Brand.FORD.name(),"ford_gt_avro_720_mirage_2008","GT Avro 720 Mirage 2008","Скорость: 354 км/ч.\nМощность: 720 л.с.\nРазгон до 100: 3.4 сек.",Class.MUSLECAR.name(), "4620000");
        Entity ford5=new Entity(Brand.FORD.name(), "ford_gt_geigercars_2010", "GT GeigerCars HP790 2010","Скорость: 360 км/ч.\nМощность: 790 л.с.\nРазгон до 100: 3.6 сек.", Class.SPORTCAR.name(),"19800000");
        Entity ford6=new Entity(Brand.FORD.name(),"ford_gt40_mk_1965","GT40 Mk I 1965","Скорость: 306 км/ч.\nМощность: 380 л.с.\nРазгон до 100: 5.5 сек.",Class.SPORTCAR.name(), "15840000");
        Entity ford7=new Entity(Brand.FORD.name(),"ford_mustang_gt_fastback_1965","Mustang GT Fastback 1965","Скорость: 176 км/ч.\nМощность: 271 л.с.\nРазгон до 100: 7.5 сек.",Class.MUSCLE_RETRO.name(),"10560000");
        Entity ford8=new Entity(Brand.FORD.name(), "ford_mustang_rtr_package_2011", "Mustang RTR Package 2011","Скорость: 250 км/ч.\nМощность: 428 л.с.\nРазгон до 100: 4.5 сек.", Class.SPORTCAR.name(),"8580000");

        Entity lambo1=new Entity(Brand.LAMBORGHINI.name(), "lambo_huraca_performante_2018", "Huracan Performante 2018", "Скорость: 335 км/ч.\nМощность: 640 л.с.\nРазгон до 100: 2.9 сек.Дизайн: 8.25", Class.SPORTCAR.name(),"17820000");
        Entity lambo2=new Entity(Brand.LAMBORGHINI.name(), "lambo_countach_1974", "Countach LP400 1974","Скорость: 316 км/ч.\nМощность: 375 л.с.\nРазгон до 100: 5.5 сек.",Class.RETRO.name(),"33000000");
        Entity lambo3=new Entity(Brand.LAMBORGHINI.name(),"lambo_aventador_svj_2019"," Aventador SVJ 2019","Скорость: 350 км/ч.\nМощность: 770 л.с.\nРазгон до 100: 2.8 сек.Дизайн: 9.85",Class.SPORTCAR.name(),"34320000");

        Entity dodge1=new Entity(Brand.DODGE.name(),"dodge_challenger_2019", "Challenger SRT Hellcat Redeye 2019","Скорость: 327 км/ч.\nМощность: 808 л.с.\nРазгон до 100: 3.5 сек.\nДизайн: 10", Class.MUSLECAR.name(),"5280000");
        Entity dodge2=new Entity(Brand.DODGE.name(), "dodge_srt_viper_ta_2014", "SRT Viper TA 2014","Скорость: 334 км/ч.\nМощность: 649 л.с.\nРазгон до 100: 3.4 сек.",Class.SPORTCAR.name(),"5940000");
        Entity dodge3=new Entity(Brand.DODGE.name(),"dodge_challenger_r1971","Challenger R/T 426 Hemi 1971","Скорость: 210 км/ч.\nМощность: 425 л.с.\nРазгон до 100: 6.2 сек.",Class.MUSCLE_RETRO.name(),"5280000");
        Entity dodge4=new Entity(Brand.DODGE.name(),"dodge_charger_1971","Charger Super Bee 1971","Скорость: 210 км/ч.\nМощность: 385 л.с.\nРазгон до 100: 6.9 сек.", Class.MUSCLE_RETRO.name(),"3960000");


        Entity porsche1=new Entity(Brand.PORSCHE.name(),"porsche_918_spyder_2014","918 Spyder 2014", "Скорость: 345 км/ч.\nМощность: 887 л.с.\nРазгон до 100: 2.8 сек.",Class.SPORTCAR.name(), "85800000");
        Entity porsche2=new Entity(Brand.PORSCHE.name(),"porsche_911_gturbo_2011","911 GTurbo R (Porsche 911 GT3) 2011","Скорость: 385 км/ч.\nМощность: 1200 л.с.\nРазгон до 100: 3.4 сек.", Class.SPORTCAR.name(),"29700000");

        List<Entity> list=new ArrayList<>();
        list.add(ferrari1); list.add(ferrari2); list.add(ferrari3);list.add(ferrari4); list.add(ferrari5);
        list.add(ferrari6);list.add(ferrari7);list.add(ferrari8);
        list.add(ford1);list.add(ford2);list.add(ford3);list.add(ford4);list.add(ford5);
        list.add(ford6);list.add(ford7);list.add(ford8);
        list.add(lambo1);list.add(lambo2); list.add(lambo3);
        list.add(dodge1); list.add(dodge2); list.add(dodge3); list.add(dodge4);
        list.add(porsche1); list.add(porsche2);
        return list;
    }
    public List<String> section1Drawables(){
        String drawable1="icon_ferrari";
        String drawable2="icon_ford";
        String drawable3="icon_lamborghini";
        String drawable4="icon_dodge";
        String drawable5="icon_porsche";
        List<String> list=new ArrayList<>();
        list.add(drawable1);
        list.add(drawable2);
        list.add(drawable3);
        list.add(drawable4);
        list.add(drawable5);
        return list;
    }
}
enum Brand {
    FERRARI,FORD,LAMBORGHINI,DODGE,PORSCHE
}
enum Class{
    SPORTCAR, MUSLECAR, RETRO, MUSCLE_RETRO
}

