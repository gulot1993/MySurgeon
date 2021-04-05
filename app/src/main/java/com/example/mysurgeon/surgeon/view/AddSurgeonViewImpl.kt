package com.example.mysurgeon.surgeon.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import com.example.mysurgeon.R
import com.example.mysurgeon.core.BaseActivity
import com.example.mysurgeon.model.Surgeon
import com.example.mysurgeon.surgeon.SurgeonViewModel
import com.example.mysurgeon.util.AppConstants
import com.example.mysurgeon.util.ViewModelFactory
import kotlinx.android.synthetic.main.layout_surgeon_add.*

class AddSurgeonViewImpl: BaseActivity(){
    private var isAddSurgeon: Boolean = false
    private var surgeon: Surgeon? = null

    private val viewModel by lazy {
        return@lazy ViewModelProvider(this, ViewModelFactory(activity = this as BaseActivity))
                .get(SurgeonViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_surgeon_add)
        getBundle()
        setUpToolbar()
        setListeners()
        setupViews()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val itemId = item.itemId
        if (itemId == R.id.save) {
            val mode = if (isAddSurgeon) {
                "ADD_SURGEON"
            } else {
                "EDIT_SURGEON"
            }
            saveSurgeon(mode)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getBundle() {
        val intentExtras = intent.extras
        if (intentExtras != null) {
            isAddSurgeon = intentExtras.getBoolean(AppConstants.ADD_SURGEON_EXTRA)
            surgeon = intentExtras.getSerializable(AppConstants.SURGEON_DATA) as Surgeon
        }
    }

    private fun setUpToolbar() {
        val title = if (isAddSurgeon) {
            getString(R.string.tv_add_surgeon)
        } else {
            getString(R.string.tv_edit_surgeon)
        }

        setUpToolbar(title)
    }

    private fun setListeners() {
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun saveSurgeon(mode: String) {
        viewModel.addOrEditSurgeon(
                mode = mode,
                surgeonUniqueID = surgeon?.SurgeonUniqueID,
                firstName = etFirstName.text.toString(),
                lastName = etLastName.text.toString(),
                hospital = etOrganization.text.toString(),
                specialization = etSpecialization.text.toString(),
                contactPerson = etContactPerson.text.toString(),
                workNo = etWork.text.toString(),
                mobileNo = etMobile.text.toString(),
                mainNo = etLandline.text.toString(),
                faxNo = etFax.text.toString(),
                multipleEmail = etEmail.text.toString(),
                url = etWebsite.text.toString(),
                street = etStreet.text.toString(),
                city = etCity.text.toString(),
                state = etState.text.toString(),
                zip = etZip.text.toString(),
                notes = etNotes.text.toString()
        )
    }

    private fun setupViews() {
        surgeon?.let {
            etFirstName.setText(it.FirstName)
            etLastName.setText(it.LastName)
            etOrganization.setText(it.Hospital)
            etSpecialization.setText(it.Specialization)
            etContactPerson.setText(it.ContactPerson)
            etWork.setText(it.WorkNo)
            etMobile.setText(it.MobileNo)
            etLandline.setText(it.MainNo)
            etFax.setText(it.FaxNo)
            etEmail.setText(it.EMail)
            etWebsite.setText(it.URL)
            etStreet.setText(it.Street)
            etCity.setText(it.City)
            etState.setText(it.State)
            etZip.setText(it.State)
            etNotes.setText(it.Notes)
        }
    }
}