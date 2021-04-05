package com.example.mysurgeon.splash.view

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.mysurgeon.R
import com.example.mysurgeon.auth.AuthStatus
import com.example.mysurgeon.auth.view.AuthRoothActivity
import com.example.mysurgeon.core.BaseActivity
import com.example.mysurgeon.main.view.MainViewImpl
import com.example.mysurgeon.splash.SplashViewModel
import com.example.mysurgeon.util.ViewModelFactory
import kotlinx.android.synthetic.main.layout_splash.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewImpl : BaseActivity(){
    private val viewModel by lazy {
        return@lazy ViewModelProvider(this, ViewModelFactory(activity = this))
            .get(SplashViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_splash)
        viewModel.start()
        initTextView()
        initViewModel()
    }

    private fun initTextView() {
        val string = SpannableString(getString(R.string.app_name))
        string.setSpan(ForegroundColorSpan(Color.BLACK),2, string.length, Spannable.SPAN_EXCLUSIVE_INCLUSIVE)
        tvAppName.text = string
    }

    private fun initViewModel() {
        viewModel.status.observe(this, Observer {
            when(it) {
                is AuthStatus.NavigateToMain -> {
                    startActivity(Intent(this@SplashViewImpl, MainViewImpl::class.java))
                    finish()
                }

                is AuthStatus.NavigateToAuth -> {
                    startActivity(Intent(this@SplashViewImpl, AuthRoothActivity::class.java))
                    finish()
                }
            }
        })
    }
}