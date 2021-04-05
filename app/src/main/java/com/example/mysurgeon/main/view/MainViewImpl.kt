package com.example.mysurgeon.main.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.mysurgeon.R
import com.example.mysurgeon.core.BaseActivity
import com.example.mysurgeon.journal.view.AddJournalViewImpl
import com.example.mysurgeon.main.view.adapter.MainPagerAdapter
import com.example.mysurgeon.procedure.view.AddProcedureViewImpl
import com.example.mysurgeon.surgeon.SurgeonViewModel
import com.example.mysurgeon.surgeon.view.AddSurgeonViewImpl
import com.example.mysurgeon.util.AppConstants
import com.example.mysurgeon.util.Extension.toast
import com.example.mysurgeon.util.ViewModelFactory
import com.facebook.drawee.backends.pipeline.Fresco
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_main.*

class MainViewImpl: BaseActivity() {
    private val adapter by lazy {
        return@lazy MainPagerAdapter(this)
    }

    private val surgeonsViewModel by lazy {
        return@lazy ViewModelProvider(this, ViewModelFactory(activity = this))
            .get(SurgeonViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_main)
        initPager()
        initToolbar()
        initBottomNavigation()
    }

    private fun initToolbar() {
        var toolbarTitle = ""
        when(pager.currentItem) {
            0 -> toolbarTitle = getString(R.string.tv_surgeons)
            1 -> toolbarTitle = getString(R.string.tv_procedures)
            2 -> toolbarTitle = getString(R.string.tv_journal)
            3 -> toolbarTitle = getString(R.string.tv_notifications)
            4 -> toolbarTitle = getString(R.string.tv_account)
        }
        setupToolbar(toolbarTitle)
    }

    private fun setupToolbar(toolbarTitle: String) {
        if (pager.currentItem <= 2) {
            toolbar.setNavigationIcon(R.drawable.ic_refresh)
        } else {
            toolbar.navigationIcon = null
        }
        setUpToolbar(toolbarTitle)

        toolbar.setNavigationOnClickListener {
            when(pager.currentItem) {
                0 -> {
                    surgeonsViewModel.loadSurgeons()
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val currentItem = pager.currentItem
        when(item.itemId) {
            R.id.add -> {
                return if (currentItem == 0) {
                    startActivity(Intent(this, AddSurgeonViewImpl::class.java)
                            .putExtra(AppConstants.ADD_SURGEON_EXTRA, true))
                    true
                } else if (currentItem == 1){
                    startActivity(Intent(this, AddProcedureViewImpl::class.java)
                            .putExtra(AppConstants.ADD_PROCEDURE_EXTRA, true))
                    true
                } else {
                    startActivity(Intent(this, AddJournalViewImpl::class.java)
                        .putExtra(AppConstants.ADD_JOURNAL_EXTRA, true))
                    true
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if (pager.currentItem <= 2) {
            menuInflater.inflate(R.menu.main_menu, menu)
        }
        return super.onCreateOptionsMenu(menu)
    }

    private fun initPager() {
        pager.adapter = adapter
        pager.offscreenPageLimit = 5
        pager.isUserInputEnabled = false

        pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                initToolbar()
            }
        })

    }

    private fun initBottomNavigation() {
        bottomNavView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.surgeon -> {
                    pager.currentItem = 0
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.procedure -> {
                    pager.currentItem = 1
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.journal -> {
                    pager.currentItem = 2
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.notification -> {
                    pager.currentItem = 3
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.account -> {
                    pager.currentItem = 4
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }
    }
}