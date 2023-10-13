package babacan.Game

import android.graphics.Path
import android.util.Log

fun Int.abs() =Math.abs(this)
fun doLinesIntersect(line1: MyLine, line2: MyLine): Boolean {
    // İki çizgiyi temsil eden başlangıç ve bitiş noktalarını alın
    val x1 = line1.p1.x
    val y1 = line1.p1.y
    val x2 = line1.p2.x

    val y2 = line1.p2.y

    val x3 = line2.p1.x
    val y3 = line2.p1.y
    val x4 = line2.p2.x
    val y4 = line2.p2.y

    // Çizgilerin sonuçlarına göre kesişip kesişmediğini kontrol edin
    if (x1 > x4 || x2 < x3 || y1 > y4 || y2 < y3) {
        // Çizgiler hiçbir noktada kesişmiyor
        return false
    }

    return true
}




fun doLinesIntersect(line1Start: MyPoint, line1End: MyPoint, line2Start: MyPoint, line2End: MyPoint): Boolean {
    val denominator =
        (line1End.y - line1Start.y) * (line2End.x - line2Start.x) - (line1End.x - line1Start.x) * (line2End.y - line2Start.y)

    if (denominator.toDouble() == 0.0) {
        return false // Lines are parallel, no intersection
    }

    val ua =
        ((line2End.x - line2Start.x) * (line1Start.y - line2Start.y) - (line2End.y - line2Start.y) * (line1Start.x - line2Start.x)) / denominator
    val ub =
        ((line1End.x - line1Start.x) * (line1Start.y - line2Start.y) - (line1End.y - line1Start.y) * (line1Start.x - line2Start.x)) / denominator

    return (ua >= 0.0 && ua <= 1.0 && ub >= 0.0 && ub <= 1.0).apply{if(this)  Log.i("kesişme", "KESİŞME")}
}

