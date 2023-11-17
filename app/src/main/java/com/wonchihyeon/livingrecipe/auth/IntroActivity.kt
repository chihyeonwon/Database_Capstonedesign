package com.wonchihyeon.livingrecipe.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.wonchihyeon.livingrecipe.MainActivity
import com.wonchihyeon.livingrecipe.databinding.ActivityIntroBinding
import com.google.firebase.auth.FirebaseAuth
import com.wonchihyeon.livingrecipe.R

// 인트로 페이지
class IntroActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private lateinit var binding : ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = FirebaseAuth.getInstance()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_intro)

        // 로그인 버튼을 눌렀을 때 로그인 페이지로 이동
        binding.loginBtn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        // 회원가입 버튼을 눌렀을 때 회원가입 페이지로 이동
        binding.joinBtn.setOnClickListener {
            val intent = Intent(this, JoinActivity::class.java)
            startActivity(intent)
        }

        // 익명 로그인 버튼을 눌렀을 때 로그인성공 메시지와 함께 메인화면으로 이동
        binding.noAccountBtn.setOnClickListener {
            auth.signInAnonymously()
                .addOnCompleteListener(this) { task ->
                    if(task.isSuccessful) {

                        Toast.makeText(this,"로그인 성공", Toast.LENGTH_LONG).show()

                        // MainAcitivity로 화면 이동
                        val intent = Intent(this, MainActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                    } else {
                        Toast.makeText(this,"로그인 실패", Toast.LENGTH_LONG).show()
                    }
                }
        }
    }
}