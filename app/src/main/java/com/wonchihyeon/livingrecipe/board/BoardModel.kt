package com.wonchihyeon.livingrecipe.board

// 게시글의 데이터 구조를 정의
data class BoardModel (
    val title: String = "",
    val content: String = "",
    val uid: String  = "",
    val time: String = ""
)