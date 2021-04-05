package com.example.mysurgeon.auth.view.fragments

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.mysurgeon.R
import com.example.mysurgeon.auth.AuthViewModel
import com.example.mysurgeon.core.BaseActivity
import com.example.mysurgeon.core.BaseFragment
import com.example.mysurgeon.util.ViewModelFactory
import kotlinx.android.synthetic.main.layout_splash.*
import kotlinx.android.synthetic.main.layout_splash.tvAppName
import kotlinx.android.synthetic.main.layout_welcome.*

class WelcomeFragment: BaseFragment() {
    private val viewModel by lazy {
        return@lazy ViewModelProvider(requireActivity(), ViewModelFactory(activity = activity as BaseActivity))
                .get(AuthViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_welcome, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAppTitle()
        initViewClickListeners()
    }

    private fun initAppTitle() {
        val spannableString = SpannableString(getString(R.string.app_name))
        spannableString.setSpan(ForegroundColorSpan(Color.BLACK),2, spannableString.length, Spannable.SPAN_EXCLUSIVE_INCLUSIVE)
        tvAppName.text = spannableString
    }

    private fun initViewClickListeners() {
        btnRegister.setOnClickListener {
           viewModel.nextPage(2)
        }

        btnLogin.setOnClickListener {
            viewModel.nextPage(1)
        }
    }
}