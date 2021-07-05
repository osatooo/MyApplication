package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Adapter の実装（データを結びつけ、ViewHolder の生成とデータ反映を行う）
 */
class MyAdapter(private val data: IntArray) : RecyclerView.Adapter<MyViewHolder>() {
    /** 表示用データの要素数（ここでは IntArray のサイズ） */
    override fun getItemCount(): Int = data.size

    /** 新しく ViewHolder オブジェクトを生成するための実装 */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyViewHolder(inflater.inflate(R.layout.item, parent, false))
    }

    /** position の位置のデータを使って、表示内容を適切に設定（更新）する */
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val num = data[position]
//        holder.label.text = "Element-$num"
        holder.button.text = "Button-$num"
    }
}