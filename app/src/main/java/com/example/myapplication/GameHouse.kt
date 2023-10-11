package com.example.myapplication

import android.util.Log
import babacan.Game.GameSource
import babacan.Game.MyRectangle
import babacan.Game.SourceType

class GameHouse(val rectangle: MyRectangle) {

    private val sourceMap: HashMap<SourceType, GameSource?> = HashMap()

    private fun notContains(source: GameSource) = sourceMap.get(source.type) == null

    private fun accept(source: GameSource) = sourceMap.put(source.type, source)

    fun acceptIfNotContained(source: GameSource): Boolean {
        return notContains(source)
            .apply {
                if (this) {
                    Log.i("houseselecting", "sorunsuz house kabul ettti")
                    accept(source)
                }


            }
    }

    fun cleanAllSources(){

        sourceMap.put(SourceType.ELECTRIC, null)
        sourceMap.put(SourceType.GAS, null)
        sourceMap.put(SourceType.WATER, null)

    }

}