package com.wonchihyeon.livingrecipe

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.wonchihyeon.livingrecipe.setting.SettingActivity
import com.google.firebase.auth.FirebaseAuth

// 메인 화면
class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        auth = FirebaseAuth.getInstance()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 우측 최상단의 세팅버튼을 누르면 로그아웃,회원탈퇴가 있는 셋팅 페이지로 이동한다.
        findViewById<ImageView>(R.id.settingBtn).setOnClickListener {
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
        }
    }
}