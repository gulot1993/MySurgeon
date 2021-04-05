package com.example.mysurgeon.auth.view.fragments

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mysurgeon.R
import com.example.mysurgeon.auth.AuthViewModel
import com.example.mysurgeon.core.BaseActivity
import com.example.mysurgeon.core.BaseFragment
import com.example.mysurgeon.core.status.Status
import com.example.mysurgeon.main.view.MainViewImpl
import com.example.mysurgeon.model.LoginRequest
import com.example.mysurgeon.util.Extension.createLoadingDialog
import com.example.mysurgeon.util.Extension.toast
import com.example.mysurgeon.util.ViewModelFactory
import kotlinx.android.synthetic.main.layout_auth_root.*
import kotlinx.android.synthetic.main.layout_sign_in.*
import kotlinx.android.synthetic.main.layout_splash.*
import kotlinx.android.synthetic.main.layout_splash.tvAppName

class SignInFragment: BaseFragment() {
    private val viewModel by lazy {
        return@lazy ViewModelProvider(this, ViewModelFactory(activity = activity as BaseActivity))
                .get(AuthViewModel::class.java)
    }

    private val loadingDialog by lazy {
        return@lazy (activity as BaseActivity).createLoadingDialog(getString(R.string.tv_loading_login))
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_sign_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAppTitle()
        initClickListeners()
        initViewModel()
    }

    private fun initViewModel() {
        viewModel.status.observe(viewLifecycleOwner, Observer {
            when(it) {
                is Status.Loading -> {
                    if (it.show) {
                        loadingDialog.show()
                    } else {
                        loadingDialog.dismiss()
                    }
                }
                is Status.Success -> {
                    startActivity(Intent(context, MainViewImpl::class.java))
                    activity?.finish()
                }
                is Status.Error -> {
                    val error = if (it.message.isNullOrEmpty()) {
                        it.resId?.let {
                            getString(it)
                        }
                    } else {
                        it.message
                    }
                   error?.let {
                       toast(it)
                   }
                }
            }
        })
    }

    private fun initAppTitle() {
        val spannableString = SpannableString(getString(R.string.app_name))
        spannableString.setSpan(ForegroundColorSpan(Color.BLACK),2, spannableString.length, Spannable.SPAN_EXCLUSIVE_INCLUSIVE)
        tvAppName.text = spannableString
    }

    private fun initClickListeners() {
        tvForgotPassword.setOnClickListener {
            viewModel.nextPage(offset = 3)
        }

        btnLogin.setOnClickListener {
            when {
                (etUsername.text.toString().isBlank() || etUsername.text.toString().isEmpty()) ||
                (etPassword.text.toString().isBlank() || etPassword.text.toString().isEmpty()) -> {
                    toast(getString(R.string.tv_empty_username_password_error))
                    return@setOnClickListener
                }
            }
            viewModel.login(LoginRequest(
                "LOGIN",
                etUsername.text.toString(),
                etPassword.text.toString())
            )
        }
    }
}