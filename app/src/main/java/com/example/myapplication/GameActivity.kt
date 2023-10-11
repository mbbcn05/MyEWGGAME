package com.example.myapplication

import android.app.Activity
import android.os.Bundle
import android.view.WindowManager


class GameActivity : Activity() {
  // private lateinit var gameView: MyGame
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    //    gameView = MyGame(this)

        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_game_launcher)
    }
}
