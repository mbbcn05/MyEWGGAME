package babacan.Game

class MyRectangle ( val p1:MyPoint,val width: Float =150f, val height: Float =150f){


    val points=listOf<MyPoint>(p1,MyPoint(p1.x+width,p1.y),MyPoint(p1.x+width,p1.y+height),
        MyPoint(p1.x,p1.y+height))


    fun distanceTo(point: MyPoint):Double{
        return points.map(point::distance).reduce{d1,d2->d1+d2}

    }

    fun contains(point: MyPoint):Boolean= distanceTo(point).toFloat() ==width+height
    fun isPointInRectangle(point:MyPoint):Boolean{
        return point.x> p1.x &&point.x<p1.x+width&&point.y>p1.y&&point.y<p1.y+height
    }
}