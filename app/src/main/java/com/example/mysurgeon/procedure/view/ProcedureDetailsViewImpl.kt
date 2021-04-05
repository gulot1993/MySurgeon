package com.example.mysurgeon.procedure.view

import android.content.Intent
import android.os.Bundle
import com.example.mysurgeon.R
import com.example.mysurgeon.core.BaseActivity
import com.example.mysurgeon.util.AppConstants
import kotlinx.android.synthetic.main.layout_procedure_detail.*

class ProcedureDetailsViewImpl: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_procedure_detail)

        setupToolbar()
        setListeners()
    }

    private fun setupToolbar() {
        setUpToolbar(getString(R.string.tv_procedures_details))
    }

    private fun setListeners() {
        ivEdit.setOnClickListener {
            startActivity(Intent(this, AddProcedureViewImpl::class.java)
                    .putExtra(AppConstants.ADD_PROCEDURE_EXTRA, false))
        }

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}