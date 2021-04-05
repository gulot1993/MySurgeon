package com.example.mysurgeon.core.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.mysurgeon.core.adapter.BaseRecyclerViewAdapter
import com.example.mysurgeon.model.Model

abstract class BaseRecyclerViewHolder <T: Model>(itemView: View): RecyclerView.ViewHolder(itemView){
    internal var onItemListener: BaseRecyclerViewAdapter.OnItemListener<T>? = null
    abstract fun onBind(data: T)
    abstract fun onRecycle()
}