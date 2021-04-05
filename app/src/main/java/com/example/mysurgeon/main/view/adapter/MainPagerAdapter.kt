package com.example.mysurgeon.main.view.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mysurgeon.account.view.AccountFragment
import com.example.mysurgeon.core.BaseActivity
import com.example.mysurgeon.journal.view.JournalFragment
import com.example.mysurgeon.procedure.view.ProcedureFragment
import com.example.mysurgeon.notification.view.NotificationFragment
import com.example.mysurgeon.surgeon.view.SurgeonFragment

class MainPagerAdapter(baseActivity: BaseActivity): FragmentStateAdapter(baseActivity) {
    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> SurgeonFragment()
            1 -> ProcedureFragment()
            2 -> JournalFragment()
            3 -> NotificationFragment()
            4 -> AccountFragment()
            else -> throw IllegalStateException("Invalid Page")
        }
    }
}