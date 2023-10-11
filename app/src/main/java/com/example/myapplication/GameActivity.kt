package com.example.myapplication

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager


class GameActivity : Activity() {
  // private lateinit var gameView: MyGame
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    //    gameView = MyGame(this)
   x = getResources().getDisplayMetrics().widthPixels
    y = getResources().getDisplayMetrics().heightPixels

      window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_game_launcher)
    }
    companion object{
         var x:Int=0
         var y:Int=0

    }
}
