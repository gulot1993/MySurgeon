package com.example.mysurgeon.notification.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mysurgeon.R
import com.example.mysurgeon.core.BaseActivity
import com.example.mysurgeon.core.BaseFragment
import com.example.mysurgeon.notification.NotificationViewModel
import com.example.mysurgeon.notification.view.adapter.NotificationAdapter
import com.example.mysurgeon.util.ViewModelFactory
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.layout_notification.*

class NotificationFragment: BaseFragment() {
    private val viewModel by lazy {
        return@lazy ViewModelProvider(requireActivity(), ViewModelFactory(requireActivity() as BaseActivity))
                .get(NotificationViewModel::class.java)
    }

    private val adapter by lazy {
        return@lazy NotificationAdapter(requireContext())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_notification, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.initNotificationItems()
        initViewModel()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        rvNotifications.adapter = adapter
        rvNotifications.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        val decorator = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        val drawable = ContextCompat.getDrawable(requireContext(), R.drawable.space_decoration)
        if (drawable != null) {
            decorator.setDrawable(drawable)
            rvNotifications.addItemDecoration(decorator)
        }
    }

    private fun initViewModel() {
        viewModel.notifications.observe(viewLifecycleOwner, Observer {
            adapter.addItems(it)
            if (it.filter { it.unread }.isNotEmpty()) {
                creatOrRemoveBadge(false, it.filter { it.unread }.size)
            } else {
                creatOrRemoveBadge(true, 0)
            }
        })
    }

    private fun creatOrRemoveBadge(isRemove: Boolean, totalUnread: Int) {
        val nav = activity?.findViewById<BottomNavigationView>(R.id.bottomNavView)
        if (nav != null) {
            if (!isRemove) {
                val badge = nav.getOrCreateBadge(R.id.notification)
                badge.isVisible = true
                badge.number = totalUnread
            } else {
                nav.removeBadge(R.id.notification)
            }
        }
    }
}