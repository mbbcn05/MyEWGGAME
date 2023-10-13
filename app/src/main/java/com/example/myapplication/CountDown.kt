package com.example.myapplication

import babacan.Game.MyPath

class CountDown {
    var second:Double=10.00

    val frameTime=0.05
    fun updateTime(){
        second-=frameTime
        if(second<0){
            Game.myPathList.removeAll { true }
            refreshTime()
            Game.houses.forEach{house->house.cleanAllSources()}
        }

    }
    fun refreshTime(){
        second=10.00

    }
}