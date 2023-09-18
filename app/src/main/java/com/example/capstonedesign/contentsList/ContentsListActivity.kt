package com.example.capstonedesign.contentsList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.capstonedesign.R

class ContentsListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contents_list)

        // activity_contents_list에서 생성한 RecycleView를 가져온다.
        val rv : RecyclerView = findViewById(R.id.rv)

        // 아이템들을 넣는다.
        val items = ArrayList<String>()
        items.add("a")
        items.add("b")
        items.add("c")

        // Activity에 있는 rv의 adavpter를 가져와서 연결한다.
        val rvAdapter = ContentRVAdapter(items)
        rv.adapter = rvAdapter

        rv.layoutManager = GridLayoutManager(this, 2)
    }
}