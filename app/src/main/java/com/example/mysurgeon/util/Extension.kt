package com.example.mysurgeon.util

import android.app.Activity
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.mysurgeon.R
import com.example.mysurgeon.core.BaseActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.dialog_loading.view.*

object Extension {
    fun BaseActivity.toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun BaseActivity.toastExtended(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    fun Fragment.toast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    fun Fragment.toastExtended(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

    fun BaseActivity.createLoadingDialog(content: String): AlertDialog {
        val loadingView = layoutInflater.inflate(R.layout.dialog_loading, null, false)
        loadingView.tvContent.text = content
        val dialogBuilder = MaterialAlertDialogBuilder(this)
            .setView(loadingView)

        return dialogBuilder.create()
    }
}