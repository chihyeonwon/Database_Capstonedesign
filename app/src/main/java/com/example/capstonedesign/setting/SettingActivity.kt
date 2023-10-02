package com.example.capstonedesign.setting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.capstonedesign.R
import com.example.capstonedesign.auth.IntroActivity
import com.example.capstonedesign.utils.FBAuth
import com.google.firebase.auth.FirebaseAuth

class SettingActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        auth = FirebaseAuth.getInstance()

        val logoutBtn: Button = findViewById(R.id.logoutBtn)

        logoutBtn.setOnClickListener {
            auth.signOut()

            // IntroActivity로 화면 이동
            val intent = Intent(this, IntroActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)

            Toast.makeText(this,"로그아웃", Toast.LENGTH_LONG).show()
        }
    }
}