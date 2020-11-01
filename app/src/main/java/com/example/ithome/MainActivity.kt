package com.example.ithome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.solver.LinearSystem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var newsList =ArrayList<News>()

    fun initNews(){
        repeat(20){
            newsList.add(News(R.drawable.one,"小米公司：在全面屏技术领域已经申请了一百多项专利","89 评"))
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initNews()

        val newsAdapter = NewsAdapter(this,R.layout.news_page,newsList)

    listViewTest.adapter=newsAdapter;

        listViewTest.setOnItemClickListener { _, _, i, _ ->
            val fruit = newsList[i]
//            Toast.makeText(this, fruit.name, Toast.LENGTH_SHORT).show()

            //跳转至聊天界面
            val intent= Intent(this,DetailedActivity::class.java)
            startActivity(intent)

        }



























    }
}