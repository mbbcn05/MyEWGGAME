package com.example.myapplication

class CountDown {
    var second:Double=10.00
        set(value) {if(value<0)Game.gameOver=true
            field=value
        }
    val frameTime=100/60
    fun updateTime(){
        second-=frameTime
    }
    fun refreshTime(){
        second=10.00

    }
}