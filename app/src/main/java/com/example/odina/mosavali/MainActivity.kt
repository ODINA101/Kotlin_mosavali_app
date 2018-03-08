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

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var regbtn = findViewById<Button>(R.id.main_regbtn)

        var main_email = findViewById<EditText>(R.id.main_email)
        regbtn.setOnClickListener({
            var reg = Intent(this,RegActivity::class.java)
            var options = ActivityOptionsCompat.makeSceneTransitionAnimation(Activity(),main_email,"sharedINP")
             startActivity(reg,options.toBundle())
        })
    }






}
