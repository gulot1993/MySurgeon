package com.example.mysurgeon.journal.view.viewholder

import android.view.View
import com.example.mysurgeon.model.Journal
import kotlinx.android.synthetic.main.layout_journal_item.view.*

class JournalItemViewHolder(itemView: View): JournalViewHolder(itemView){
    override fun onBind(data: Journal) {
        itemView.tvSurgeonName.text = data.surgeon
        itemView.tvProcedureName.text = data.procedure
        itemView.tvStartDate.text = data.startDate
        itemView.tvEndDate.text = data.endDate
    }

    override fun onRecycled() {

    }
}