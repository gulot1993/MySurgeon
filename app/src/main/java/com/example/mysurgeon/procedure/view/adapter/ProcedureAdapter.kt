package com.example.mysurgeon.procedure.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mysurgeon.R
import com.example.mysurgeon.core.adapter.BaseRecyclerViewAdapter
import com.example.mysurgeon.core.viewholder.BaseRecyclerViewHolder
import com.example.mysurgeon.model.Procedure
import com.example.mysurgeon.procedure.view.viewholder.ProcedureHeaderViewHolder
import com.example.mysurgeon.procedure.view.viewholder.ProcedureItemViewHolder

class ProcedureAdapter(val context: Context): BaseRecyclerViewAdapter<Procedure, BaseRecyclerViewHolder<Procedure>>(){
    private var isHeader = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseRecyclerViewHolder<Procedure>{
        return if (isHeader == 1) {
            ProcedureHeaderViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_feed_header, parent, false))
        } else {
            ProcedureItemViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_procedure_item, parent, false))
        }
    }

    override fun onViewRecycled(holder: BaseRecyclerViewHolder<Procedure>) {
        super.onViewRecycled(holder)
        holder.onRecycle()
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        isHeader = if (items[position].isHeader) {
            1
        } else {
            0
        }
        return isHeader
    }


}