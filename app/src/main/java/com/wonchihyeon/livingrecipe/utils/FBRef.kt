package com.wonchihyeon.livingrecipe.utils

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

// 파이어베이스 실시간 데이터베이스의 관련 설정을 위한 클래스
class FBRef {

    companion object {

        private val database = Firebase.database

        // contents 경로의 데이터베이스 경로를 선언
        val category1 = database.getReference("contents")

        // contents2 경로의 데이터베이스 경로를 선언
        val category2 = database.getReference("contents2")

        // bookmark_list 경로의 데이터베이스 경로를 선언
        val bookmarkRef = database.getReference("bookmark_list")

        // board 경로의 데이터베이스 경로를 선언
        val boardRef = database.getReference("board")

        // comment 경로의 데이터베이스 경로를 선언
        val commentRef = database.getReference("comment")

    }
}