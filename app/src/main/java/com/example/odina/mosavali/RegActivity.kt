package com.example.odina.mosavali

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.activity_reg.*
import java.util.concurrent.TimeUnit
import javax.security.auth.callback.Callback

class RegActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)
        var backbtn = findViewById<ImageButton>(R.id.regbtn_back)

        backbtn.setOnClickListener({
            onBackPressed()
        })
        dastruribtn.setOnClickListener({

            startPhoneNumberVerification("+995597918113")


        })

    }
    private fun startPhoneNumberVerification(phoneNumber: String) {
        var mCallbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks
        mCallbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {

            }

            override fun onVerificationFailed(e: FirebaseException) {
                // This callback is invoked if an invalid request for verification is made,
                // for instance if the the phone number format is invalid.


                if (e is FirebaseAuthInvalidCredentialsException) {
                    // Invalid request
                } else if (e is FirebaseTooManyRequestsException) {
                    // The SMS quota for the project has been exceeded
                }

            }
            override fun onCodeSent(verificationId: String?,
                                    token: PhoneAuthProvider.ForceResendingToken?) {
                // The SMS verification code has been sent to the provided phone number, we
                // now need to ask the user to enter the code and then construct a credential
                // by combining the code with a verification ID.
                // Save verification ID and resending token so we can use them later

            }
        }
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber, // Phone number to verify
                60,             // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,           // Activity (for callback binding)
                mCallbacks)        // OnVerificationStateChangedCallbacks
    }
}