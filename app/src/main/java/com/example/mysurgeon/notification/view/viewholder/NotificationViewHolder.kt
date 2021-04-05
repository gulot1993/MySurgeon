package com.example.mysurgeon.notification.view.viewholder

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.mysurgeon.R
import com.example.mysurgeon.model.Notification
import kotlinx.android.synthetic.main.layout_notification_item.view.*

class NotificationViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun onBind(data: Notification) {
        if (data.unread) {
            itemView.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.colorLightGray))
        } else {
            itemView.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.colorWhite))
        }
        itemView.tvNotifMesssage.text = data.message
        itemView.tvDate.text = data.dateCreated
    }

    fun onRecycled() {

    }
}