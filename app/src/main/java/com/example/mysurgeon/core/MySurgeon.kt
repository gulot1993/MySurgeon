package com.example.mysurgeon.core

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.squareup.picasso.Picasso

class MySurgeon: Application() {
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
        Picasso.get().isLoggingEnabled = true
    }
}