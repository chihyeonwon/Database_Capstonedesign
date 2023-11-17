package com.wonchihyeon.livingrecipe.contentsList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wonchihyeon.livingrecipe.R
import com.wonchihyeon.livingrecipe.utils.FBAuth
import com.wonchihyeon.livingrecipe.utils.FBRef
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ContentsListActivity : AppCompatActivity() {

    lateinit var myRef : DatabaseReference

    val bookmarkIdList = mutableListOf<String>()

    lateinit var rvAdapter: ContentRVAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contents_list)

        // 아이템들을 넣는다.
        val items = ArrayList<ContentModel>()
        // 아이템 키 값을 저장하는 변수
        val itemKeyList = ArrayList<String>()

        // Activity에 있는 rv의 adavpter를 가져와서 연결한다.
        rvAdapter = ContentRVAdapter(baseContext, items, itemKeyList, bookmarkIdList)

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

        // Firebase Database의 북마크 데이터를 불러오는 부분
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

        getBookmarkData()
        
        // 북마크 데이터를 수동으로 넣는 부분
        /*myRef = database.getReference("contents")

        items
            .add(ContentModel("밥솥 리코타치즈 황금레시피","https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FblYPPY%2Fbtq66v0S4wu%2FRmuhpkXUO4FOcrlOmVG4G1%2Fimg.png","https://philosopher-chan.tistory.com/1235"))
        items
            .add(ContentModel("황금노른자장 황금레시피","https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FznKK4%2Fbtq665AUWem%2FRUawPn5Wwb4cQ8BetEwN40%2Fimg.png","https://philosopher-chan.tistory.com/1236"))
        items
            .add(ContentModel("사골곰탕 파스타 황금레시피","https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fbtig9C%2Fbtq65UGxyWI%2FPRBIGUKJ4rjMkI7KTGrxtK%2Fimg.png","https://philosopher-chan.tistory.com/1237"))
        items
            .add(ContentModel("아웃백 투움바 파스타 황금레시피","https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcOYyBM%2Fbtq67Or43WW%2F17lZ3tKajnNwGPSCLtfnE1%2Fimg.png","https://philosopher-chan.tistory.com/1238"))
        items
            .add(ContentModel("최애 당면 찜닭 황금레시피","https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fekn5wI%2Fbtq66UlN4bC%2F8NEzlyot7HT4PcjbdYAINk%2Fimg.png","https://philosopher-chan.tistory.com/1239"))
        items
            .add(ContentModel("스팸 부대 국수 황금레시피","https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2F123LP%2Fbtq65qy4hAd%2F6dgpC13wgrdsnHigepoVT1%2Fimg.png","https://philosopher-chan.tistory.com/1240"))
        items
            .add(ContentModel("불닭 팽이버섯 황금레시피","https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fl2KC3%2Fbtq64lkUJIN%2FeSwUPyQOddzcj6OAkPKZuk%2Fimg.png","https://philosopher-chan.tistory.com/1241"))
        items
            .add(ContentModel("꿀호떡 샌드위치 황금레시피","https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FmBh5u%2Fbtq651yYxop%2FX3idRXeJ0VQEoT1d6Hln30%2Fimg.png","https://philosopher-chan.tistory.com/1242"))
        items
            .add(ContentModel("굽네치킨 황금레시피","https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FlOnja%2Fbtq69Tmp7X4%2FoUvdIEteFbq4Z0ZtgCd4p0%2Fimg.png","https://philosopher-chan.tistory.com/1243"))
        items
            .add(ContentModel("야매 JMT 홈베이킹 황금레시피","https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FNNrYR%2Fbtq64wsW5VN%2FqIaAsfmFtcvh4Bketug9m0%2Fimg.png","https://philosopher-chan.tistory.com/1244"))
        items
            .add(ContentModel("자취요리 양념장레시피","https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FK917N%2Fbtq64SP5gxj%2FNzsfNAykamW7qv1hdusp1K%2Fimg.png","https://philosopher-chan.tistory.com/1245"))
        items
            .add(ContentModel("디톡스주스 레시피모음","https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FeEO4sy%2Fbtq69SgK8L3%2FttCUxYHx9aPNebNwkPcI21%2Fimg.png","https://philosopher-chan.tistory.com/1246"))
        items
            .add(ContentModel("사랑듬뿍담긴 봄소풍도시락","https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbdIKDG%2Fbtq64M96JFa%2FKcJiYgKuwKuP3fIyviXm90%2Fimg.png","https://philosopher-chan.tistory.com/1247"))
        items
            .add(ContentModel("참치맛나니 초간단레시피","https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FFtY3t%2Fbtq65q6P4Zr%2FWe64GM8KzHAlGE3xQ2nDjk%2Fimg.png","https://philosopher-chan.tistory.com/1248"))
        items
            .add(ContentModel("간장볶음면 마성의레시피","https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FOtaMq%2Fbtq67OMpk4W%2FH1cd0mda3n2wNWgVL9Dqy0%2Fimg.png","https://philosopher-chan.tistory.com/1249"))

        for (i in items){
            myRef.push().setValue(i)
        }*/

    }
    // 북마크 데이터를 가져오는 getBookmarkData 함수
    private fun getBookmarkData() {
        val postListner = object: ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                // 북마크리스트 초기화
                bookmarkIdList.clear()

                // dataModel에 있는 데이터를 하나씩 가져오는 부분
                for(dataModel in dataSnapshot.children) {
                    bookmarkIdList.add(dataModel.key.toString())
                }
                Log.d("ContentListActivity", bookmarkIdList.toString())
                rvAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w("ContentListActivity", "loadPost:onCancelled", databaseError.toException())
            }
        }
        FBRef.bookmarkRef.child(FBAuth.getUid()).addValueEventListener(postListner)
    }
}