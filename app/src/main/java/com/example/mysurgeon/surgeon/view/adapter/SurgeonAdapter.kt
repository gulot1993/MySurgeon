package com.example.mysurgeon.surgeon.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mysurgeon.R
import com.example.mysurgeon.core.adapter.BaseRecyclerViewAdapter
import com.example.mysurgeon.core.viewholder.BaseRecyclerViewHolder
import com.example.mysurgeon.model.Surgeon
import com.example.mysurgeon.surgeon.view.viewholder.SurgeonHeaderViewHolder
import com.example.mysurgeon.surgeon.view.viewholder.SurgeonItemViewHolder
import kotlinx.android.synthetic.main.layout_surgeons_feed_item.view.*

class SurgeonAdapter(val context: Context): BaseRecyclerViewAdapter<Surgeon, BaseRecyclerViewHolder<Surgeon>>() {
    private var isHeader = 0
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseRecyclerViewHolder<Surgeon> {
        return if (isHeader == 1) {
            SurgeonHeaderViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_feed_header, parent, false))
        } else {
            SurgeonItemViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_surgeons_feed_item, parent, false))
        }
    }

    override fun onBindViewHolder(holder: BaseRecyclerViewHolder<Surgeon>, position: Int) {
        super.onBindViewHolder(holder, position)
        if (holder is SurgeonItemViewHolder) {
            holder.itemView.ivLogo.setImageURI("https://i.imgur.com/tGbaZCY.jpg")
        }
    }

    override fun getItemViewType(position: Int): Int {
        isHeader = if (items[position].isHeader) {
            1
        } else {
            0
        }
        return isHeader
    }
}