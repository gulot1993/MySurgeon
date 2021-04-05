package com.example.mysurgeon.notification

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mysurgeon.core.BaseViewModel
import com.example.mysurgeon.core.di.CoreComponent
import com.example.mysurgeon.model.Notification

class NotificationViewModel(coreComponent: CoreComponent): BaseViewModel() {

    private val dummyList = mutableListOf<Notification>()
    private val _notifications = MutableLiveData<List<Notification>>()
    val notifications: LiveData<List<Notification>>
        get() = _notifications

    init {
        dummyList.add(Notification("Regulos Minor shared Rey Joel Matugas's information with you",
                "October 7, 2015 11:00PM",
                false))
        dummyList.add(Notification("Rey Joel Matugas shared Rey Joel Matugas's information with you",
                "October 8, 2015 11:00PM",
                true))
        dummyList.add(Notification("Regulos Minor shared Rey Joel Matugas's information with you",
                "October 9, 2015 11:00PM",
                true))
        dummyList.add(Notification("Regulos Minor shared Rey Joel Matugas's information with you",
                "October 10, 2015 11:00PM",
                true))
        dummyList.add(Notification("Regulos Minor shared Rey Joel Matugas's information with you",
                "October 11, 2015 11:00PM",
                true))
    }

    fun initNotificationItems() {
        _notifications.value = dummyList
    }
    override fun onDestroy() {

    }

    override fun initComponentInjection() {

    }
}