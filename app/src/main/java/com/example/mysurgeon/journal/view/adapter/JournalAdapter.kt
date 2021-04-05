package com.example.mysurgeon.journal.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mysurgeon.R
import com.example.mysurgeon.journal.view.viewholder.JournalFooterViewHolder
import com.example.mysurgeon.journal.view.viewholder.JournalHeaderViewHolder
import com.example.mysurgeon.journal.view.viewholder.JournalItemViewHolder
import com.example.mysurgeon.journal.view.viewholder.JournalViewHolder
import com.example.mysurgeon.model.Journal
import com.example.mysurgeon.util.AppConstants

class JournalAdapter(private val context: Context): RecyclerView.Adapter<JournalViewHolder>() {
    private val items = mutableListOf<Journal>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JournalViewHolder {
        return when(viewType) {
            1 -> JournalHeaderViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_feeder_header_white_bg, parent, false))
            2 -> JournalItemViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_journal_item, parent, false))
            else -> {
                JournalFooterViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_feed_footer, parent, false))
            }
        }
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: JournalViewHolder, position: Int) {
        holder.onBind(data = items[position])
    }

    override fun getItemViewType(position: Int): Int {
        return when(items[position].type) {
            AppConstants.ITEM_HEADER -> 1
            AppConstants.ITEM_CONTENT -> 2
            else -> {
                3
            }
        }
    }

    fun setData(items: List<Journal>) {
        this.items.addAll(items)
    }
}