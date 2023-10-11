package babacan.Game

import android.util.Log
import com.example.myapplication.MyGame

class MyRectangle (val p1:MyPoint, val width: Float = MyGame.x/10f, val height: Float =MyGame.y/7f){


    val points=listOf<MyPoint>(p1,MyPoint(p1.x+width,p1.y),MyPoint(p1.x+width,p1.y+height),
        MyPoint(p1.x,p1.y+height))


    fun distanceTo(point: MyPoint):Double{
        return points.map(point::distance).reduce{d1,d2->d1+d2}

    }

    fun contains(point: MyPoint):Boolean= distanceTo(point).toFloat() ==width+height
    fun isPointInRectangle(point:MyPoint):Boolean{

        return (point.x> p1.x &&point.x<p1.x+width&&point.y>p1.y&&point.y<p1.y+height).apply{if(this) {Log.i("kare","kare seçildi")}}
    }
}