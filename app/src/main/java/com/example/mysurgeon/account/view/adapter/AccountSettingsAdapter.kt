package com.example.mysurgeon.account.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mysurgeon.R
import com.example.mysurgeon.account.view.viewholder.AccountSettingsViewHolder
import com.example.mysurgeon.core.adapter.BaseRecyclerViewAdapter
import com.example.mysurgeon.model.Settings

class AccountSettingsAdapter(private val context: Context): BaseRecyclerViewAdapter<Settings, AccountSettingsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountSettingsViewHolder {
        return AccountSettingsViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_account_item, parent, false))
    }
}