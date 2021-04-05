package com.example.mysurgeon.journal.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.mysurgeon.model.Journal

abstract class JournalViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    abstract fun onBind(data: Journal)
    abstract fun onRecycled()
}