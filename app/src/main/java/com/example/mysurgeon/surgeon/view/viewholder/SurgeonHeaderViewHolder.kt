package com.example.mysurgeon.surgeon.view.viewholder

import android.view.View
import com.example.mysurgeon.core.viewholder.BaseRecyclerViewHolder
import com.example.mysurgeon.model.Surgeon
import kotlinx.android.synthetic.main.layout_feed_header.view.*

class SurgeonHeaderViewHolder(itemView: View): BaseRecyclerViewHolder<Surgeon>(itemView) {
    override fun onBind(data: Surgeon) {
        itemView.tvLastNameFirstLetter.text = data.LastName?.first().toString()
    }

    override fun onRecycle() {

    }
}