package com.example.mysurgeon.notification.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mysurgeon.R
import com.example.mysurgeon.model.Notification
import com.example.mysurgeon.notification.view.viewholder.NotificationViewHolder

class NotificationAdapter(private val context: Context): RecyclerView.Adapter<NotificationViewHolder>() {

    private val items = mutableListOf<Notification>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        return NotificationViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_notification_item, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.onBind(items[position])
    }

    fun addItems(items: List<Notification>) {
        this.items.addAll(items)
    }
}