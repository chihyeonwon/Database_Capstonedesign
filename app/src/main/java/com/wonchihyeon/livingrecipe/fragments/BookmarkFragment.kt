package com.wonchihyeon.livingrecipe.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wonchihyeon.livingrecipe.R
import com.wonchihyeon.livingrecipe.contentsList.BookmarkRVAdapter
import com.wonchihyeon.livingrecipe.contentsList.ContentModel
import com.wonchihyeon.livingrecipe.databinding.FragmentBookmarkBinding
import com.wonchihyeon.livingrecipe.utils.FBAuth
import com.wonchihyeon.livingrecipe.utils.FBRef
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

// 북마크 페이지
class BookmarkFragment : Fragment() {

    private lateinit var binding: FragmentBookmarkBinding
    // TODO: Rename and change types of parameters

    lateinit var rvAdapter: BookmarkRVAdapter

    val bookmarkIdList = mutableListOf<String>()
    val items = ArrayList<ContentModel>()
    val itemKeyList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bookmark, container, false)

        // 사용자가 북마크한 정보를 다 가져온다.
        getBookmarkData()

        // 전체 컨텐츠 중에서, 사용자가 북마크한 정보만 보여준다.
        rvAdapter = BookmarkRVAdapter(requireContext(), items, itemKeyList, bookmarkIdList)

        val rv: RecyclerView = binding.bookmarkRV
        rv.adapter = rvAdapter

        rv.layoutManager = GridLayoutManager(requireContext(),2)

        binding.tipTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_bookmarkFragment_to_tipFragment)
        }

        binding.homeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_bookmarkFragment_to_homeFragment)
        }

        binding.talkTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_bookmarkFragment_to_talkFragment)
        }

        binding.storeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_bookmarkFragment_to_storeFragment)
        }

        return binding.root
    }
    // 컨텐츠 데이터를 받아오는 함수
    private fun getCategoryData() {
        val postListner = object: ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // dataModel에 있는 데이터를 하나씩 가져오는 부분
                for(dataModel in dataSnapshot.children) {
                    val item = dataModel.getValue(ContentModel::class.java)

                    // 전체 컨텐츠 중에서, 사용자가 북마크한 정보만 보여준다.
                    if(bookmarkIdList.contains(dataModel.key.toString())) {
                        items.add(item!!)
                        itemKeyList.add(dataModel.key.toString())
                    }
                }
                rvAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w("ContentListActivity", "loadPost:onCancelled", databaseError.toException())
            }
        }
        FBRef.category1.addValueEventListener(postListner)
        FBRef.category2.addValueEventListener(postListner)
    }

    // 북마크 데이터를 가져오는 함수
    private fun getBookmarkData() {
        val postListner = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                // dataModel에 있는 데이터를 하나씩 가져오는 부분
                for (dataModel in dataSnapshot.children) {
                    bookmarkIdList.add(dataModel.key.toString())
                }
                // 전체 카테고리에 있는 컨텐츠 데이터들을 다 가져온다.
                getCategoryData()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w("ContentListActivity", "loadPost:onCancelled", databaseError.toException())
            }
        }
        FBRef.bookmarkRef.child(FBAuth.getUid()).addValueEventListener(postListner)
    }
}