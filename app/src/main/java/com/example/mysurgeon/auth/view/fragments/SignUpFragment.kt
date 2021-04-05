package com.example.mysurgeon.auth.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mysurgeon.R
import com.example.mysurgeon.auth.AuthViewModel
import com.example.mysurgeon.core.BaseActivity
import com.example.mysurgeon.core.BaseFragment
import com.example.mysurgeon.core.status.Status
import com.example.mysurgeon.main.view.MainViewImpl
import com.example.mysurgeon.util.Extension.createLoadingDialog
import com.example.mysurgeon.util.Extension.toast
import com.example.mysurgeon.util.ViewModelFactory
import kotlinx.android.synthetic.main.layout_auth_root.*
import kotlinx.android.synthetic.main.layout_sign_up.*
import timber.log.Timber

class SignUpFragment: BaseFragment(), AdapterView.OnItemSelectedListener {
    private val viewModel by lazy {
        return@lazy ViewModelProvider(this, ViewModelFactory(activity = activity as BaseActivity))
                .get(AuthViewModel::class.java)
    }
    private val loadingDialog by lazy {
        return@lazy (activity as BaseActivity).createLoadingDialog(getString(R.string.tv_loading_signup))
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViewModel()
        setUpViewListeners()
    }

    private fun setUpViewListeners() {
        btnSubmit.setOnClickListener {
            viewModel.register(
                    mode = "REGISTRATION",
                    promoCode = "",
                    firstName = etFirstName.text.toString(),
                    lastName = etLastName.text.toString(),
                    email = etEmail.text.toString(),
                    username = etUsername.text.toString(),
                    password = etPassword.text.toString(),
                    retypedPassword = etConfirmPassword.text.toString(),
                    street = etStreet.text.toString(),
                    state = spStates.selectedItem.toString(),
                    city = etCity.text.toString(),
                    zip = etZip.text.toString(),
                    mobileNo = etMobile.text.toString(),
                    landlineNo = etLandline.text.toString(),
                    email_update = "true",
                    iphone_update = "true"
            )
        }
    }

    private fun setUpViewModel() {
        viewModel.getStates()
        viewModel.states.observe(viewLifecycleOwner, Observer {
            val adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, it)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spStates.onItemSelectedListener = this
            spStates.adapter = adapter
        })
        viewModel.status.observe(viewLifecycleOwner, Observer {
            when(it) {
                is Status.Loading -> {
                    if (it.show) {
                        loadingDialog.show()
                    } else {
                        loadingDialog.dismiss()
                    }
                }
                is Status.Success -> {

                }
                is Status.Error -> {
                    val error = if (it.message.isNullOrEmpty()) {
                        it.resId?.let {
                            getString(it)
                        }
                    } else {
                        it.message
                    }
                    error?.let {
                        toast(it)
                    }
                }
            }
        })
    }

    override fun onItemSelected(parent: AdapterView<*>?, p1: View?, position: Int, p3: Long) {

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}