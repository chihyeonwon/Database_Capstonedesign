package com.example.capstonedesign.board

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.capstonedesign.R

class BoardListLVAdapter(val boardList : MutableList<BoardModel>): BaseAdapter() {
    override fun getCount(): Int {
        return boardList.size
    }

    override fun getItem(position: Int): Any {
        return boardList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    // view를 가져와서 item과 연결해주는 부분
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view = convertView

        if(view== null) {

            view = LayoutInflater.from(parent?.context).inflate(R.layout.board_list_item, parent,false)
        }

        val title = view?.findViewById<TextView>(R.id.titleArea)
        title!!.text = boardList[position].title

        return view!!
    }

}