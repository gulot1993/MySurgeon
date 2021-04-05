package com.example.mysurgeon.journal.repository

import com.example.mysurgeon.core.network.NetworkModule
import javax.inject.Inject

class JournalRepositoryImpl @Inject constructor(): JournalRepository {

    private val api
        get() = NetworkModule.getInstance().provideApi()

    override suspend fun addOrEditAppointment(
        mode: String,
        userID: String,
        appointmentID: String?,
        location: String,
        surgeonName: String,
        selectedSurgeonName: String,
        procedureUniqueID: String,
        selectedProcedudeName: String,
        procedureName: String,
        notes: String,
        startDate: String,
        startTime: String,
        startPeriod: String,
        endDate: String,
        endTime: String,
        endPeriod: String,
        accessToken: String
    ) {
        if (mode == "ADD_APPOINTMENT" && appointmentID == null) {
            api.addAppointment(mode,
                userID,
                location,
                surgeonName,
                selectedSurgeonName,
                procedureUniqueID,
                selectedProcedudeName,
                procedureName,
                notes,
                startDate,
                startTime,
                startPeriod,
                endDate,
                endTime,
                endPeriod,
                accessToken)
        } else {
            api.editAppointment(mode,
                userID,
                appointmentID!!,
                location,
                surgeonName,
                selectedSurgeonName,
                procedureUniqueID,
                selectedProcedudeName,
                procedureName,
                notes,
                startDate,
                startTime,
                startPeriod,
                endDate,
                endTime,
                endPeriod,
                accessToken)
        }
    }
}