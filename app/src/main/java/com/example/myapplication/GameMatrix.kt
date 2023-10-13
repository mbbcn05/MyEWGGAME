package com.example.myapplication

import android.util.Log
import babacan.Game.MyLine
import babacan.Game.MyPath
import babacan.Game.abs

object GameMatrix {
    private var x=0
    private var y=0
    //val matrix = Array(3000) { Array(3000) { 0 } }
   val matrix = Array(30000) { ByteArray(30000) }
    //val matrix = ByteArray(3000 * 3000)



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
                matrix[x][y] = (matrix[x][y] + 1).toByte()
            }else{
                y+=increaseY
                matrix[x][y] = (matrix[x][y] + 1).toByte()
            }
            if(matrix[x][y]==2.toByte()) {
                isIntersection=true
                Log.i("KESİŞME!!","BİR ADET KESİŞME")
            }

        }



    }
    fun addLines( lines: List<MyLine>){
        lines.forEach{line->addLine(line.p1.x.toInt(), line.p1.y.toInt(),
            line.p2.x.toInt(), line.p2.y.toInt()
        )}
    }
}