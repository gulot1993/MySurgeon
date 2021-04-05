package com.example.mysurgeon.journal.repository

import retrofit2.http.Query

interface JournalRepository {
    suspend fun addOrEditAppointment(mode: String,
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
                                accessToken: String)
}