package com.example.mysurgeon.procedure.view

import android.os.Bundle
import android.view.Menu
import com.example.mysurgeon.R
import com.example.mysurgeon.core.BaseActivity
import com.example.mysurgeon.util.AppConstants
import kotlinx.android.synthetic.main.layout_surgeon_add.*

class AddProcedureViewImpl: BaseActivity() {

    private var isAddProcedure = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_procedure_add)

        getBundle()
        setUpToolbar()
        setListeners()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun getBundle() {
        val intentExtras = intent.extras
        if (intentExtras != null) {
            isAddProcedure = intentExtras.getBoolean(AppConstants.ADD_PROCEDURE_EXTRA)
        }
    }

    private fun setUpToolbar() {
        val title = if (isAddProcedure) {
            getString(R.string.tv_add_procedure)
        } else {
            getString(R.string.tv_edit_procedure)
        }

        setUpToolbar(title)
    }

    private fun setListeners() {
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}