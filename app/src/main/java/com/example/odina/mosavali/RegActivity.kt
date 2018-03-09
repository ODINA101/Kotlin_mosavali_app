package com.example.odina.mosavali

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.ImageButton
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.activity_reg.*
import java.util.concurrent.TimeUnit
import javax.security.auth.callback.Callback
import android.widget.Toast
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.AuthResult
import com.google.android.gms.tasks.Task
import android.support.annotation.NonNull
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.database.FirebaseDatabase


class RegActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)
        var backbtn = findViewById<ImageButton>(R.id.regbtn_back)

        backbtn.setOnClickListener({
            onBackPressed()
        })
        dastruribtn.setOnClickListener({
           var mAuth = FirebaseAuth.getInstance()

            mAuth.signInAnonymously()
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            val user = mAuth.currentUser

                            if (user != null) {
                              var map = HashMap<String,String>()
                                map["phone"] = reg_number.text.toString()
                                map["name"] = reg_name.text.toString()
                                map["region"] = raioni.text.toString()
                                map["password"] = paroli.text.toString()
                                map["uid"] = user.uid

                                FirebaseDatabase.getInstance().getReference("Users").child(user.uid).setValue(map).addOnCompleteListener({
                                    var home = Intent(this,homeActivity::class.java)
                                    startActivity(home)
                                })



                            }

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(this@RegActivity, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show()
                        }

                        // ...
                    }

        })

    }





}