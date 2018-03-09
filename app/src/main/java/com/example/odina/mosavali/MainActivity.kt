package com.example.odina.mosavali

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.ActivityOptionsCompat
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        var main_number = findViewById<EditText>(R.id.main_nomeri)


        main_regbtn.setOnClickListener({
            val reg = Intent(this,RegActivity::class.java)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this,main_number,"sharedINP")
             startActivity(reg,options.toBundle())
        })
    }






}
