package com.example.mysurgeon.core

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mysurgeon.R
import com.example.mysurgeon.auth.view.AuthRoothActivity
import com.example.mysurgeon.core.di.CoreComponent
import com.example.mysurgeon.core.di.CoreModule
import com.example.mysurgeon.core.di.DaggerCoreComponent
import com.example.mysurgeon.main.view.MainViewImpl
import com.google.android.material.appbar.MaterialToolbar
import timber.log.Timber

open class BaseActivity : AppCompatActivity() {

    val coreComponent by lazy { initialize() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun setUpToolbar(title: String) {
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)

        if (toolbar != null) {
            val tvTitle = toolbar.findViewById<TextView>(R.id.title)
            tvTitle.text = title
            setSupportActionBar(toolbar)
            supportActionBar?.title = ""

            if (this !is MainViewImpl && this !is AuthRoothActivity) {
                toolbar.setNavigationIcon(R.drawable.ic_back)
            }
        }
    }

    private fun initialize(): CoreComponent {
        Timber.plant(Timber.DebugTree())
        val component = DaggerCoreComponent.builder()
                .coreModule(CoreModule(this))
                .build()
        return component
    }
}