package com.example.deliverykotlin

import android.util.Log
class Loger {

    companion object{
        private val LOG: String="MyLog"
        fun message(any: String?){
            var message: String=any.toString()
            Log.d(LOG, message)
        }
    }
}