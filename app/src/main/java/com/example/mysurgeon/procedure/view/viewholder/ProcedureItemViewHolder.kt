package com.example.mysurgeon.procedure.view.viewholder

import android.view.View
import com.example.mysurgeon.core.viewholder.BaseRecyclerViewHolder
import com.example.mysurgeon.model.Procedure
import kotlinx.android.synthetic.main.layout_procedure_item.view.*

class ProcedureItemViewHolder(itemView: View): BaseRecyclerViewHolder<Procedure>(itemView){
    override fun onBind(data: Procedure) {
        itemView.tvProcedureName.text = data.name
        itemView.tvLinkedSurgeonCount.text = data.linkedSurgeon.toString()
        itemView.tvNotLinkedSurgeonCount.text = data.unlinkedSurgeon.toString()
        itemView.ivArrowRight.visibility = View.VISIBLE

        itemView.setOnClickListener {
            onItemListener?.onItemPressed(data, adapterPosition)
        }
    }

    override fun onRecycle() {
        itemView.ivArrowRight.visibility = View.GONE
    }
}