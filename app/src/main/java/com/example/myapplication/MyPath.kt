package babacan.Game

import android.icu.lang.UCharacter.LineBreak
import java.nio.file.Path
import java.util.Collections


class MyPath (val source:GameSource) {
    var lines = Collections.synchronizedList(mutableListOf<MyLine>())
    var point: MyPoint? = null
    fun clipLinesInRectangle(rectangle: MyRectangle, rectangle2: MyRectangle): MyPath {

        val removingLines = mutableListOf<MyLine>()
        lines.forEach { line ->
            if (rectangle.isPointInRectangle(line.p1) && rectangle.isPointInRectangle(line.p2) ||
                rectangle2.isPointInRectangle(line.p1) && rectangle2.isPointInRectangle(line.p2)
            ) {
                removingLines.add(line)
            }
           // path.lines.addAll(lines.toList())
            //path.lines.removeAll((removingLines).toList())



        }
        val path = MyPath(source)
        val newLines=lines.toMutableList()
        newLines.removeAll(removingLines)
        path.lines = newLines
        return path
    }

    fun addLines(x: Float, y: Float) {

        if (point != null) {
            lines.add(MyLine(point!!, MyPoint(x, y)))

        }
        point = MyPoint(x, y)
    }


   private fun intersectWithLine(line: MyLine): Boolean =
        lines.count { ln -> doLinesIntersect(ln.p1, ln.p2,line.p1,line.p2) } > 0

  private  fun intersects(other: MyPath) = other.lines.count { line -> intersectWithLine(line) } > 0
fun intersectsWithPaths(paths:List<MyPath>):Boolean=paths.count{path->intersects(path)}>0

}