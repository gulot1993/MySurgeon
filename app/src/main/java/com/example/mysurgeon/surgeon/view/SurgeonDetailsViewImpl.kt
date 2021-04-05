package com.example.mysurgeon.surgeon.view

import android.content.Intent
import android.os.Bundle
import com.example.mysurgeon.R
import com.example.mysurgeon.core.BaseActivity
import com.example.mysurgeon.model.Surgeon
import com.example.mysurgeon.util.AppConstants
import kotlinx.android.synthetic.main.layout_main.toolbar
import kotlinx.android.synthetic.main.layout_surgeons_detail.*
import kotlinx.android.synthetic.main.layout_surgeons_detail.tvContactPerson

class SurgeonDetailsViewImpl: BaseActivity() {

    private var surgeon: Surgeon? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_surgeons_detail)

        setupToolbar()
        setupViews()
        setListeners()
    }

    private fun setupViews() {
       intent.extras?.let {
           surgeon = it.getSerializable(AppConstants.SURGEON_DATA) as Surgeon
           surgeon?.let {
               tvSurgeonName.text = "${it.FirstName} ${it.LastName}"
               tvLocation.text = it.location
               tvContactPerson.text = it.ContactPerson
               tvWorkNumber.text = it.WorkNo
               tvCellNumber.text = it.MobileNo
               tvTelNumber.text = it.MainNo
               tvFaxNumber.text = it.FaxNo
               tvEmail.text = it.EMail
               tvWebsiteUrl.text = it.URL
               tvMailingAddress.text = "${it.location}, ${it.State}, ${it.Zip}"
           }
       }
    }

    private fun setupToolbar() {
        setUpToolbar(getString(R.string.tv_surgeon_details))
    }

    private fun setListeners() {
        val bundle = Bundle()
        bundle.putSerializable(AppConstants.SURGEON_DATA, surgeon)
        bundle.putBoolean(AppConstants.ADD_SURGEON_EXTRA, false)
        ivEdit.setOnClickListener {
            startActivity(Intent(this, AddSurgeonViewImpl::class.java)
                    .putExtras(bundle))
        }
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}