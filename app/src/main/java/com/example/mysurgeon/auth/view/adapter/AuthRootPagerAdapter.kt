package com.example.mysurgeon.auth.view.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mysurgeon.auth.view.fragments.ForgotPassword
import com.example.mysurgeon.auth.view.fragments.SignInFragment
import com.example.mysurgeon.auth.view.fragments.SignUpFragment
import com.example.mysurgeon.auth.view.fragments.WelcomeFragment
import com.example.mysurgeon.core.BaseActivity

class AuthRootPagerAdapter(baseActivity: BaseActivity): FragmentStateAdapter(baseActivity) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> WelcomeFragment()
            1 -> SignInFragment()
            2 -> SignUpFragment()
            3 -> ForgotPassword()
            else -> throw IllegalStateException("Invalid page")
        }
    }

}