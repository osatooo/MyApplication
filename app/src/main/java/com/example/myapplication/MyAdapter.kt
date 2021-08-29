package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckedTextView

class MyAdapter(
    private val context: Context,
    private var itemList: Array<String>
) : BaseAdapter() {

    override fun getCount(): Int {
        return itemList.size
    }

    override fun getItem(position: Int): Any {
        return itemList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = LayoutInflater.from(context)
        val convertView = inflater.inflate(R.layout.item, parent, false)
        val checkedTextView = convertView.findViewById<CheckedTextView>(R.id.checked_text_view)

        //viewに要素を設定
        checkedTextView.setText(itemList[position])

        // ①viewにクリックリスナーを設定
        checkedTextView.setOnClickListener {
            if (checkedTextView.isChecked) {
                //押し直した時にAndroidのマークになるように設定
                checkedTextView.setCheckMarkDrawable(R.drawable.ic_android_black_24dp)
                checkedTextView.isChecked = false
            } else {
                //1回押した時にチェックマークが出るように設定
                checkedTextView.setCheckMarkDrawable(R.drawable.ic_baseline_check_24)
                checkedTextView.isChecked = true
            }
        }
        return checkedTextView
    }
}