package com.example.myapplication

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


    private val map = mutableMapOf<Int, Boolean>()//①mapのインスタンスを生成
    data class MyViewHolder(val checkedTextView: CheckedTextView)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val (holder, view) = if(convertView == null) {
            // 初回時など、convertViewがnullの場合のみinflateする
            val inflater = LayoutInflater.from(context)
            val v = inflater.inflate(R.layout.item, parent, false)
            val checkedTextView = v.findViewById<CheckedTextView>(R.id.checked_text_view)
            val viewHolder = MyViewHolder(checkedTextView)
            v.tag = viewHolder
            viewHolder to v
        } else {
            // 再利用時など、convertViewがnullでない場合はviewを再利用する
            convertView.tag as MyViewHolder to convertView
        }
        holder.checkedTextView.text = itemList[position]
        if (map[position] == true) {//③map[position]がtrueのときチェックマークを設置
            holder.checkedTextView.setCheckMarkDrawable(R.drawable.ic_baseline_check_24)
        } else { //③map[position]がnullもしくはfalseのときAndroidマークを設置
            holder.checkedTextView.setCheckMarkDrawable(R.drawable.ic_android_black_24dp)
        }

        // viewにクリックリスナーを設定
        holder.checkedTextView.setOnClickListener {
            val view = it as CheckedTextView
            if (map[position] == true) {
                //③map[position]がtrueのときチェックマークを設置
                view.setCheckMarkDrawable(R.drawable.ic_android_black_24dp)
                map[position] = false //②positionをキーとして真偽値を追加
            } else {
                //③map[position]がnullもしくはfalseのときAndroidマークを設置
                view.setCheckMarkDrawable(R.drawable.ic_baseline_check_24)
                map[position] = true //②positionをキーとして真偽値を追加
            }
        }
        return view
    }
}