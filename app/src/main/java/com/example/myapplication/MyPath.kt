package babacan.Game

import android.icu.lang.UCharacter.LineBreak
import java.nio.file.Path


class MyPath (val source:GameSource){
    var lines= mutableListOf<MyLine>()
var point:MyPoint?=null
   suspend fun clipLinesInRectangle(rectangle: MyRectangle,rectangle2:MyRectangle): MutableList<MyLine> {
        var path = MyPath(source)
        val removingLines = mutableListOf<MyLine>()
        lines.forEach { line ->
            if (rectangle.isPointInRectangle(line.p1) && rectangle.isPointInRectangle(line.p2) ||
                rectangle2.isPointInRectangle(line.p1) && rectangle2.isPointInRectangle(line.p2)
            ) {
                removingLines.add(line)
            }
             path.lines.addAll(lines)
                path.lines.removeAll((removingLines))
            //lines.removeAll(removingLines)


        }
        return path.lines
    }

    fun addLines(x:Float,y:Float){

        if(point!=null){
            lines.add(MyLine(point!!,MyPoint(x,y)))

        }
        point=MyPoint(x,y)
    }
}