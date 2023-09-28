package com.example.capstonedesign.contentsList

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.capstonedesign.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ContentsListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contents_list)

        lateinit var myRef : DatabaseReference

        // 아이템들을 넣는다.
        val items = ArrayList<ContentModel>()
        // 아이템 키 값을 저장하는 변수
        val itemKeyList = ArrayList<String>()

        // Activity에 있는 rv의 adavpter를 가져와서 연결한다.
        val rvAdapter = ContentRVAdapter(baseContext, items, itemKeyList)

        // Write a message to the database
        val database = Firebase.database

        val category = intent.getStringExtra("category")

        // 클릭했을 때 넘어오는 category값이 category1일 때와 category2일 때를 구분
        if(category == "category1") {
            // category가 1이면 myref는 contents의 데이터를 가져오고
            myRef = database.getReference("contents")
        } else if(category == "category2") {
            // category가 1이면 myref는 contents2의 데이터를 가져온다
            myRef = database.getReference("contents2")
        }

        // Firebase Database의 데이터 읽기
        val postListner = object: ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // dataModel에 있는 데이터를 하나씩 가져오는 부분
                for(dataModel in dataSnapshot.children) {
                    Log.d("ContentListActivity",dataSnapshot.toString())

                    // 가져온 데이터를 컨텐츠 모델 형태로 받는 부분
                    val item = dataModel.getValue(ContentModel::class.java)
                    items.add(item!!)
                    itemKeyList.add(dataModel.key.toString())
                }
                // 데이터를 받고 나서 어뎁터 동기화하는 부분
                rvAdapter.notifyDataSetChanged()
                Log.d("ContentListActivity",items.toString())
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w("ContentListActivity", "loadPost:onCancelled", databaseError.toException())
            }
        }
        myRef.addValueEventListener(postListner)


        // activity_contents_list에서 생성한 RecycleView를 가져온다.
        val rv : RecyclerView = findViewById(R.id.rv)

        rv.adapter = rvAdapter

        rv.layoutManager = GridLayoutManager(this, 2)

    }
}