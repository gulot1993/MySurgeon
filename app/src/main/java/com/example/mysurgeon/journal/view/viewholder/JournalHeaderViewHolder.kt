package com.example.mysurgeon.journal.view.viewholder

import android.view.View
import com.example.mysurgeon.model.Journal
import kotlinx.android.synthetic.main.layout_feeder_header_white_bg.view.*

class JournalHeaderViewHolder(itemView: View): JournalViewHolder(itemView) {
    override fun onBind(data: Journal) {
        val dates = data.startDate.split(",")
        itemView.tvLastNameFirstLetter.text = "${dates[2]},${dates[3]}"
    }

    override fun onRecycled() {

    }
}