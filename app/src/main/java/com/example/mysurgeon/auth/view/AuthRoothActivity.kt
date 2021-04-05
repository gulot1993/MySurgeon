package com.example.mysurgeon.auth.view

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.mysurgeon.R
import com.example.mysurgeon.auth.AuthViewModel
import com.example.mysurgeon.auth.view.adapter.AuthRootPagerAdapter
import com.example.mysurgeon.core.BaseActivity
import com.example.mysurgeon.core.status.PageMovements
import com.example.mysurgeon.util.ViewModelFactory
import kotlinx.android.synthetic.main.layout_auth_root.*

class AuthRoothActivity: BaseActivity() {

    private val adapter by lazy {
        return@lazy AuthRootPagerAdapter(this)
    }

    private val viewModel by lazy {
        return@lazy ViewModelProvider(this, ViewModelFactory(this))
                .get(AuthViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_auth_root)

        initViewPager()
        initViewModel()
        initToolbar()
    }

    private fun initToolbar() {
        var toolbarTitle = ""
        when(pager.currentItem) {
            1 -> toolbarTitle = getString(R.string.tv_sign_in)
            2 -> toolbarTitle = getString(R.string.tv_sign_up)
        }
        setUpToolbar(toolbarTitle)
    }

    override fun onBackPressed() {
        when (val currentPosition = pager.currentItem) {
            in 1..2 -> {
                viewModel.previousPage(currentPosition)
            }
            3 -> {
                viewModel.previousPage(2)
            }
            else -> {
                super.onBackPressed()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initViewPager() {
        pager.adapter = adapter
        pager.isUserInputEnabled = false

        pager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                invalidateOptionsMenu()
                initToolbar()
                if (position == 0) {
                    appBarLayout.visibility = View.GONE
                    supportActionBar?.setDisplayHomeAsUpEnabled(false)
                } else {
                    appBarLayout.visibility = View.VISIBLE
                    supportActionBar?.setDisplayHomeAsUpEnabled(true)
                }
            }
        })
    }

    private fun initViewModel() {
        viewModel.status.observe(this, Observer {
            when(it) {
                is PageMovements.NextPage -> {
                    pager.setCurrentItem(it.offset, true)
                }

                is PageMovements.PreviousPage -> {
                    pager.setCurrentItem(pager.currentItem - it.offset, true)
                }
            }
        })
    }
}