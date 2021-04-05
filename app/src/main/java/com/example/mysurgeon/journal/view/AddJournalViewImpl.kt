package com.example.mysurgeon.journal.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.mysurgeon.R
import com.example.mysurgeon.core.BaseActivity
import com.example.mysurgeon.core.BaseFragment
import com.example.mysurgeon.journal.JournalViewModel
import com.example.mysurgeon.util.AppConstants
import com.example.mysurgeon.util.ViewModelFactory
import kotlinx.android.synthetic.main.layout_add_journal.*

class AddJournalViewImpl: BaseActivity() {
    private val viewModel by lazy {
        return@lazy ViewModelProvider(this, ViewModelFactory(activity = this))
            .get(JournalViewModel::class.java)
    }

    private var isAddJournal = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_add_journal)
        setupToolbar()
    }

    private fun setupToolbar() {
        if (intent.extras != null && intent.extras!!.getBoolean(AppConstants.ADD_JOURNAL_EXTRA)) {
            isAddJournal = true
        }
        val title = if (isAddJournal) {
            "Add Journal"
        } else {
            "Edit Journal"
        }
        setUpToolbar(title)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}