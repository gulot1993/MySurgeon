package com.example.mysurgeon.surgeon.repository

import com.example.mysurgeon.core.PreferenceHelper
import com.example.mysurgeon.core.data.toSurgeon
import com.example.mysurgeon.core.network.NetworkModule
import com.example.mysurgeon.core.service.API
import com.example.mysurgeon.model.Surgeon
import javax.inject.Inject

class SurgeonRepositoryImpl @Inject constructor(): SurgeonRepository {
    private val api: API
        get() = NetworkModule.getInstance().provideApi()

    @Inject
    lateinit var preferenceHelper: PreferenceHelper
    override suspend fun getSurgeons(): List<Surgeon> {
        return api.getSurgeons("SURGEON", preferenceHelper.loginInfo!!.userID).map { it.toSurgeon() }
    }

    override suspend fun addOrEditSurgeon(mode: String, surgeonUniqueID: String?, firstName: String, lastName: String, hospital: String, specialization: String, contactPerson: String, workNo: String, mobileNo: String, mainNo: String, faxNo: String, multipleEmail: String, url: String, street: String, city: String, state: String, zip: String, notes: String) {
        if (mode == "ADD_SURGEON" && surgeonUniqueID == null) {
            api.addSurgeon(
                mode,
                preferenceHelper.loginInfo!!.accessToken,
                preferenceHelper.loginInfo!!.userID,
                firstName,
                lastName,
                hospital,
                specialization,
                contactPerson,
                workNo,
                mobileNo,
                mainNo,
                faxNo,
                multipleEmail,
                url,
                street,
                city,
                state,
                zip,
                notes
            )
        } else {
            api.editSurgeon(
                mode,
                preferenceHelper.loginInfo!!.accessToken,
                preferenceHelper.loginInfo!!.userID,
                surgeonUniqueID!!,
                firstName,
                lastName,
                hospital,
                specialization,
                contactPerson,
                workNo,
                mobileNo,
                mainNo,
                faxNo,
                multipleEmail,
                url,
                street,
                city,
                state,
                zip,
                notes
            )
        }
    }

    override suspend fun viewSurgeon(surgeonUniqueID: String) {
        api.viewSurgeon("VIEW_SURGEON", surgeonUniqueID, preferenceHelper.loginInfo!!.accessToken, preferenceHelper.loginInfo!!.userID)
    }

}