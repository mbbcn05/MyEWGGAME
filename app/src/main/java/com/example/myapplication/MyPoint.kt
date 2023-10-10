package babacan.Game
class MyPoint(val x:Float,val y:Float) {
    fun distance(other:MyPoint):Double{
        return Math.sqrt(Math.pow((x-other.x).toDouble(),2.0)+Math.pow((y-other.y).toDouble(),2.0))
    }
}