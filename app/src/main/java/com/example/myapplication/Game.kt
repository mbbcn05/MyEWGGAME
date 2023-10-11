package com.example.myapplication

import android.util.Log
import babacan.Game.GameSource
import babacan.Game.MyPath
import babacan.Game.MyPoint
import babacan.Game.MyRectangle
import babacan.Game.SourceType

object Game {

    lateinit var countDown: CountDown

    init {
        countDown = CountDown()


    }

    var creathingPath: MyPath? = null

    val myPathList: MutableList<MyPath> = mutableListOf()
    var gameOver = false////OBSERVABLE YAP
    val houses: List<GameHouse> = listOf(
        GameHouse(MyRectangle(MyPoint(110f, 100f))),
        GameHouse(MyRectangle(MyPoint(620f, 100f))),
        GameHouse(MyRectangle(MyPoint(1190f, 100f)))
    )

    val sources: List<GameSource> = listOf(
        GameSource(MyRectangle(MyPoint(110f, 450f)), SourceType.ELECTRIC),
        GameSource(MyRectangle(MyPoint(620f, 450f)), SourceType.GAS),
        GameSource(MyRectangle(MyPoint(1190f, 450f)), SourceType.WATER)
    )


    fun handleSourceSelecting(point: MyPoint) {
        if (creathingPath == null) {
            sources.forEach {
                if (it.shape.isPointInRectangle(point)) {
                    creathingPath = MyPath(it)
                    Log.i("Source selecting", "source seçildi")


                }
            }

        }
    }
    fun handleSourceMoving(x:Float,y:Float){

        creathingPath?.let { it.addLines(x,y)

    }
    }
       // fun handleSourceMoving(pointA: MyPoint, pointB: MyPoint) {
          //  creathingPath?.let { it.lines.add(MyLine(pointA, pointB)) }
        //}

        fun handleHouseSelecting(point: MyPoint) {
            var houseSelecting=false
            houses.forEach {
                if (it.rectangle.isPointInRectangle(point) && it.acceptIfNotContained(creathingPath!!.source)) {
                    houseSelecting=true
                    creathingPath!!.apply {
                       // clipLinesInRectangle(it.rectangle)
                        //clipLinesInRectangle(this.source.shape)
                       // GameMatrix.addPath(this)
                        //if (GameMatrix.isIntersection) {
                          //  Log.i("houseselecting","intersection oldu")
                            //gameOver = true
                        //} else {
                            Log.i("houseselecting","sounsuz pathliste eklendi")
                            myPathList.add(this)
                        creathingPath = null
return
                        //}

                    }

                } else {
                    //gameOver = true
                    Log.i("houseselecting","Game Over")

                }
            }
            if(!houseSelecting){
            creathingPath=null
            }

        }
    }
