package com.example.mysurgeon.surgeon.view

import android.os.Bundle
import com.example.mysurgeon.R
import com.example.mysurgeon.core.BaseActivity
import com.example.mysurgeon.model.Surgeon
import com.example.mysurgeon.util.AppConstants
import kotlinx.android.synthetic.main.layout_surgeon_share.*

class SurgeonShareViewImpl: BaseActivity() {

    private var isShareViewSms: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_surgeon_share)
        getBundle()
        setUpListeners()
    }

    private fun getBundle() {
        val intent = intent.extras
        intent?.let {
            isShareViewSms = it.getBoolean("isSms")
            val data = it.getSerializable(AppConstants.SURGEON_DATA) as Surgeon
            setupToolbar(data)
        }
    }

    private fun setupToolbar(data: Surgeon) {
        val title = "Share ${data.FirstName} ${data.LastName}'s info"
        setUpToolbar(title = title)
    }

    private fun setUpListeners() {
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}