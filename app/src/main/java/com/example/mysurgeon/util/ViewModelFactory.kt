package com.example.mysurgeon.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mysurgeon.account.AccountSettingsViewModel
import com.example.mysurgeon.auth.AuthViewModel
import com.example.mysurgeon.core.BaseActivity
import com.example.mysurgeon.journal.JournalViewModel
import com.example.mysurgeon.main.MainViewModel
import com.example.mysurgeon.notification.NotificationViewModel
import com.example.mysurgeon.procedure.ProcedureViewModel
import com.example.mysurgeon.splash.SplashViewModel
import com.example.mysurgeon.surgeon.SurgeonViewModel

class ViewModelFactory(val activity: BaseActivity): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(AuthViewModel::class.java) -> {
                AuthViewModel(coreComponent = activity.coreComponent) as T
            }
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(coreComponent = activity.coreComponent) as T
            }
            modelClass.isAssignableFrom(SurgeonViewModel::class.java) -> {
                SurgeonViewModel(coreComponent = activity.coreComponent) as T
            }
            modelClass.isAssignableFrom(ProcedureViewModel::class.java) -> {
                ProcedureViewModel(coreComponent = activity.coreComponent) as T
            }
            modelClass.isAssignableFrom(JournalViewModel::class.java) -> {
                JournalViewModel(coreComponent = activity.coreComponent) as T
            }
            modelClass.isAssignableFrom(NotificationViewModel::class.java) -> {
                NotificationViewModel(coreComponent = activity.coreComponent) as T
            }
            modelClass.isAssignableFrom(AccountSettingsViewModel::class.java) -> {
                AccountSettingsViewModel(coreComponent = activity.coreComponent) as T
            }
            modelClass.isAssignableFrom(SplashViewModel::class.java) -> {
                SplashViewModel(coreComponent = activity.coreComponent) as T
            }
            else -> throw IllegalArgumentException("Unknown Viewmodel Class")
        }

    }
}