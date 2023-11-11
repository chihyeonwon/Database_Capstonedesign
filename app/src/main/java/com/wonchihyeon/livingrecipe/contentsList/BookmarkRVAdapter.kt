package com.wonchihyeon.livingrecipe.contentsList

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wonchihyeon.livingrecipe.R

class BookmarkRVAdapter(val context: Context,
                       val items: ArrayList<ContentModel>,
                       val keyList : ArrayList<String>,
                       val bookmarkIdList: MutableList<String>)
    : RecyclerView.Adapter<BookmarkRVAdapter.Viewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkRVAdapter.Viewholder {
        // 만든 content_rv_item layout을 가져온다.
        val v = LayoutInflater.from(parent.context).inflate(R.layout.content_rv_item, parent, false)
        return Viewholder(v)
    }

    override fun onBindViewHolder(holder: BookmarkRVAdapter.Viewholder, position: Int){
        // item을 넣을 수 있도록 연결(Binding)
        holder.bindItems(items[position], keyList[position])
    }

    override fun getItemCount(): Int {
        // 전체 아이템의 개수가 몇개인지
        return items.size
    }

    inner class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(item : ContentModel, key: String) {

            itemView.setOnClickListener{
                val intent = Intent(context, ContentShowActivity::class.java)
                intent.putExtra("url", item.webUrl)
                itemView.context.startActivity(intent)
            }

            val contentTitle = itemView.findViewById<TextView>(R.id.textArea)
            val imageViewArea = itemView.findViewById<ImageView>(R.id.imageArea)
            val bookmarkArea = itemView.findViewById<ImageView>(R.id.bookmarkArea)

            if(bookmarkIdList.contains(key)) {
                bookmarkArea.setImageResource(R.drawable.bookmark_color)
            } else {
                bookmarkArea.setImageResource(R.drawable.bookmark_white)
            }

            contentTitle.text = item.title

            // base Context Glide
            Glide.with(context)
                .load(item.imageUrl)
                .into(imageViewArea)
        }
    }

}