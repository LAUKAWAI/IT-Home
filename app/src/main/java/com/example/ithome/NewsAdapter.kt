package com.example.ithome

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class NewsAdapter(context: Context, private val resource: Int, data: List<News>) :
        ArrayAdapter<News>(context, resource, data) {
    inner class ViewHolder(
            val newsImage: ImageView,
            val newsTheme: TextView,
            val newsComment: TextView,
            val newsTime: TextView
    )

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val viewHolder: ViewHolder
        val view: View
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(resource, parent, false)
            val newsImage:ImageView=view.findViewById(R.id.news_Image)
            val newsTheme:TextView=view.findViewById(R.id.news_Theme)
            val newsComment:TextView=view.findViewById(R.id.news_Comment)
            val newsTime:TextView=view.findViewById(R.id.news_Time)
            viewHolder=ViewHolder(newsImage,newsTheme,newsComment,newsTime)
            view.tag=viewHolder
        }else{
            view=convertView
            viewHolder=view.tag as ViewHolder
        }
        val news=getItem(position)
        if (news!=null){
            viewHolder.newsImage.setImageResource(news.imageId)
            viewHolder.newsTheme.text=news.theme
            viewHolder.newsComment.text=news.comment
            viewHolder.newsTime.text=getTime()
        }
        return view
    }
    private fun getTime(): String{
        val data = Date()
        val dateFormat = SimpleDateFormat("HH:mm",Locale.CHINA)
        return dateFormat.format(data)
    }
}






































