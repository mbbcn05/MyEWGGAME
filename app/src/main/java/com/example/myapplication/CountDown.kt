package com.example.myapplication

class CountDown {
    var second:Double=10.00

    val frameTime=0.02
    fun updateTime(){
        second-=frameTime
    }
    fun refreshTime(){
        second=10.00

    }
}