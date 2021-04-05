package com.example.mysurgeon.core

import androidx.fragment.app.Fragment

open class BaseFragment: Fragment() {

    protected fun setUpToolbar(title: String) {
        val baseActivity = activity as BaseActivity?
        baseActivity?.setUpToolbar(title)
    }
}