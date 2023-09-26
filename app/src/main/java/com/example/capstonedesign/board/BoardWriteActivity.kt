package com.example.capstonedesign.board

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.capstonedesign.R
import com.example.capstonedesign.databinding.ActivityBoardWriteBinding

class BoardWriteActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBoardWriteBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board_write)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_board_write)

    }
}