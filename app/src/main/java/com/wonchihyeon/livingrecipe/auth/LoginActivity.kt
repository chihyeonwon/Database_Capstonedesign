package com.wonchihyeon.livingrecipe.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.wonchihyeon.livingrecipe.MainActivity
import com.wonchihyeon.livingrecipe.R
import com.wonchihyeon.livingrecipe.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

// 로그인 페이지
class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        auth = FirebaseAuth.getInstance()

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_login)

        // 로그인 버튼을 눌렀을 때 로그인 시도 
        binding.loginBtn.setOnClickListener {

            var email = binding.emailArea.text.toString()
            var password = binding.passwordArea.text.toString()

            // 로그인에 성공하면 로그인성공 메시지와 함께 메인 페이지로 이동, 실패하면 실패메시지만 출력
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task->
                    if(task.isSuccessful) {

                        val intent = Intent(this, MainActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)

                        Toast.makeText(this,"로그인 성공", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this,"로그인 실패", Toast.LENGTH_LONG).show()
                    }
                }
        }
    }
}