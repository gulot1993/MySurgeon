package com.example.mysurgeon.core

import androidx.lifecycle.ViewModel

abstract class BaseViewModel: ViewModel() {
    abstract fun onDestroy()
    abstract fun initComponentInjection()
}