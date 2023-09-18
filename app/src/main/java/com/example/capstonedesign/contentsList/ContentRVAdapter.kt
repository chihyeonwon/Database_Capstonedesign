package com.example.capstonedesign.contentsList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.capstonedesign.R

class ContentRVAdapter(val items: ArrayList<ContentModel>) : RecyclerView.Adapter<ContentRVAdapter.Viewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentRVAdapter.Viewholder {
        // 만든 content_rv_item layout을 가져온다.
        val v = LayoutInflater.from(parent.context).inflate(R.layout.content_rv_item, parent, false)
        return Viewholder(v)
    }

    override fun onBindViewHolder(holder: ContentRVAdapter.Viewholder, position: Int){
        // item을 넣을 수 있도록 연결(Binding)
        holder.bindItems(items[position])
    }

    override fun getItemCount(): Int {
        // 전체 아이템의 개수가 몇개인지
        return items.size
    }

    inner class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(item : ContentModel) {
            val contentTitle = itemView.findViewById<TextView>(R.id.textArea)
            contentTitle.text = item.title
        }
    }

}