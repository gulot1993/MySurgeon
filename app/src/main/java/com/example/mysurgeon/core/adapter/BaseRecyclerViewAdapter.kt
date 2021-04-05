package com.example.mysurgeon.core.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.mysurgeon.core.viewholder.BaseRecyclerViewHolder
import com.example.mysurgeon.model.Model

abstract class BaseRecyclerViewAdapter<T: Model, VH: BaseRecyclerViewHolder<T>>:
    RecyclerView.Adapter<VH>(){

    internal var items = mutableListOf<T>()

    var onItemListener: OnItemListener<T>? = null

    interface OnItemListener<T> {
        fun onItemPressed(data: T, position: Int)
        fun onItemSend(data: T, position: Int, isSms: Boolean)
    }

    open fun setItemListener(itemListener: BaseRecyclerViewAdapter.OnItemListener<T>) {
        this.onItemListener = itemListener
    }

    open fun set(data: List<T>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onItemListener = onItemListener
        holder.onBind(items[position])
    }

    override fun onViewRecycled(holder: VH) {
        super.onViewRecycled(holder)
        holder.onRecycle()
    }

    override fun getItemCount(): Int = items.size

}