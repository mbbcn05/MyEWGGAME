package com.example.myapplication

import android.util.Log
import babacan.Game.GameSource
import babacan.Game.MyPath
import babacan.Game.MyPoint
import babacan.Game.MyRectangle
import babacan.Game.SourceType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object Game {

    lateinit var countDown: CountDown

    init {
        countDown = CountDown()


    }

    var creathingPath: MyPath? = null

    val myPathList: MutableList<MyPath> = mutableListOf()
    var gameOver = false////OBSERVABLE YAP
    val houses: List<GameHouse> = listOf(
        GameHouse(MyRectangle(MyPoint(MyGame.x / 8f, MyGame.y / 5f))),
        GameHouse(MyRectangle(MyPoint(MyGame.x / 2f - 0.5f * MyGame.x / 8f, MyGame.y / 5f))),
        GameHouse(MyRectangle(MyPoint(MyGame.x - 2 * MyGame.x / 8f, MyGame.y / 5f)))
    )

    val sources: List<GameSource> = listOf(
        GameSource(
            MyRectangle(MyPoint(MyGame.x / 8f, MyGame.y - 3 * MyGame.y / 7f)),
            SourceType.ELECTRIC
        ),
        GameSource(
            MyRectangle(
                MyPoint(
                    MyGame.x / 2f - 0.5f * MyGame.x / 8f,
                    MyGame.y - 3 * MyGame.y / 7f
                )
            ), SourceType.GAS
        ),
        GameSource(
            MyRectangle(MyPoint(MyGame.x - 2 * MyGame.x / 8f, MyGame.y - 3 * MyGame.y / 7f)),
            SourceType.WATER
        )
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

    fun handleSourceMoving(x: Float, y: Float) {

        creathingPath?.let {
            it.addLines(x, y)

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

                /*    CoroutineScope(Dispatchers.IO).launch {
                        //GameMatrix.addLines(clipLinesInRectangle(it.rectangle, creathingPath.let{source.shape}))
                        GameMatrix.addLines(creathingPath!!.lines)
                    }*/




                    // GameMatrix.addLines(clipLinesInRectangle(it.rectangle,this.source.shape))
                    //if (GameMatrix.isIntersection) {
                    //  Log.i("houseselecting","intersection oldu")
                    //gameOver = true
                    //} else {
                    Log.i("houseselecting","sounsuz pathliste eklendi")
                    myPathList.add(this)
                    creathingPath = null
                    countDown.refreshTime()
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
