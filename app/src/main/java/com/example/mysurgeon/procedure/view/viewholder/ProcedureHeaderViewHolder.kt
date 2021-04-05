package com.example.mysurgeon.procedure.view.viewholder

import android.view.View
import com.example.mysurgeon.core.viewholder.BaseRecyclerViewHolder
import com.example.mysurgeon.model.Procedure
import kotlinx.android.synthetic.main.layout_feed_header.view.*


class ProcedureHeaderViewHolder(itemView: View): BaseRecyclerViewHolder<Procedure>(itemView){
    override fun onBind(data: Procedure) {
        itemView.tvLastNameFirstLetter.text = data.name.first().toString()
    }

    override fun onRecycle() {

    }
}