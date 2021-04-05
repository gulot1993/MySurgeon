package com.example.mysurgeon.procedure.repository

import com.example.mysurgeon.core.PreferenceHelper
import com.example.mysurgeon.core.network.NetworkModule
import javax.inject.Inject

class ProcedureRepositoryImpl @Inject constructor(): ProcedureRepository {
    @Inject
    lateinit var preferenceHelper: PreferenceHelper
    private val api
        get() = NetworkModule.getInstance().provideApi()
    override suspend fun addOrEditProcedure(
        mode: String,
        procedureUniqueID: String?,
        userID: String,
        procedureName: String,
        procedureCode: String,
        vendor: String,
        favIntruments: String,
        positioning: String,
        dressing: String,
        woundClosure: String,
        notes: String,
        switchCase: String,
        surgeonUniqueID: String,
        accessToken: String
    ) {
        if (mode == "EDIT_SURGEON" && procedureUniqueID != null) {
            api.editProcedure(
                mode,
                procedureUniqueID,
                userID,
                procedureName,
                procedureCode,
                vendor,
                favIntruments,
                positioning,
                dressing,
                woundClosure,
                notes,
                switchCase,
                surgeonUniqueID,
                accessToken
            )
        } else {
            api.addProcedure(
                mode,
                userID,
                procedureName,
                procedureCode,
                vendor,
                favIntruments,
                positioning,
                dressing,
                woundClosure,
                notes,
                switchCase,
                surgeonUniqueID,
                accessToken
            )
        }
    }
}