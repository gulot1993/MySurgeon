package com.example.mysurgeon.auth.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mysurgeon.R
import com.example.mysurgeon.core.BaseFragment

class ForgotPassword: BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_forgot_password, container, false)
    }
}