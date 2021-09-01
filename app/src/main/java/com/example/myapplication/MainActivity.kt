package com.example.myapplication

import android.os.Bundle
import android.widget.BaseAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //方法② arrayからとってくる
        val itemList = resources.getStringArray(R.array.nutrients)

        //activity_main.xmlに定義したListViewを読み込む
        val listView = findViewById<ListView>(R.id.list_view)
        // リスト項目とListViewを対応付けるArrayAdapterを用意する
        // ArrayAdapterではcontext、1項目分のレイアウトファイル、項目を定義した配列を指定する
        val adapter: BaseAdapter = MyAdapter(this, itemList)
        listView.adapter = adapter
    }
}