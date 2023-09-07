package com.example.capstonedesign.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.capstonedesign.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class JoinActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)
        auth = FirebaseAuth.getInstance()

        auth.createUserWithEmailAndPassword("abc@abc.com", "abcdabcd")
            .addOnCompleteListener(this) { task ->
                if(task.isSuccessful) {
                    Toast.makeText(this,"성공", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this,"실패",Toast.LENGTH_LONG).show()
                }
            }
    }
}