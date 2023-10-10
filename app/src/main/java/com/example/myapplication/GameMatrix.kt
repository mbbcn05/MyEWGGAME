package com.example.myapplication

import android.util.Log
import babacan.Game.MyPath
import babacan.Game.abs

object GameMatrix {
    private var x=0
    private var y=0
    val matrix = Array(1920) { Array(1080) { 0 } }

    var isIntersection:Boolean=false

    private fun addLine(a:Int,b:Int,c:Int,d:Int){
        Log.i("addline","addline çalıştı.")
        matrix[a][b]=1
        matrix[c][d]=1
        x=a
        y=b
        fun distantX()=c-x
        fun distantY()=d-y
        val increaseX=if(distantX()>0) 1 else if (distantX()<0) -1 else 0
        val increaseY=if(distantX()>0) 1 else if (distantY()<0) -1 else 0
        while(x != c || y != d){

            if (distantX().abs() > distantY().abs()){
                x+=increaseX
                matrix[x][y]+=1
            }else{
                y+=increaseY
                matrix[x][y]+=1
            }
            if(matrix[x][y]==2) isIntersection=true
        }



    }
    fun addPath ( path: MyPath){
        path.lines.forEach{line->addLine(line.p1.x.toInt(), line.p1.y.toInt(),
            line.p2.x.toInt(), line.p2.y.toInt()
        )}
    }
}