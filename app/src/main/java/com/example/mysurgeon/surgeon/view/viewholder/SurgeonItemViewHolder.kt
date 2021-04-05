package com.example.mysurgeon.surgeon.view.viewholder

import android.view.View
import com.example.mysurgeon.core.viewholder.BaseRecyclerViewHolder
import com.example.mysurgeon.model.Surgeon
import kotlinx.android.synthetic.main.layout_surgeons_feed_item.view.*

class SurgeonItemViewHolder(itemView: View): BaseRecyclerViewHolder<Surgeon>(itemView) {
    override fun onBind(data: Surgeon) {
        val name = "${data.LastName}, ${data.FirstName}"
        itemView.tvLocation.text = data.location
        itemView.tvName.text = name

        itemView.mainLayout.setOnClickListener {
            onItemListener?.onItemPressed(data, adapterPosition)
        }

        itemView.tvSms.setOnClickListener {
            onItemListener?.onItemSend(data, adapterPosition, true)
        }

        itemView.tvEmail.setOnClickListener {
            onItemListener?.onItemSend(data, adapterPosition, false)
        }
    }

    override fun onRecycle() {

    }

}