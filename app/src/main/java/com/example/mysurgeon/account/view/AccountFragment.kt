package com.example.mysurgeon.account.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mysurgeon.R
import com.example.mysurgeon.account.view.adapter.AccountSettingsAdapter
import com.example.mysurgeon.core.BaseFragment

class AccountFragment: BaseFragment() {
    private val adapter by lazy {
        return@lazy AccountSettingsAdapter(requireContext())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}