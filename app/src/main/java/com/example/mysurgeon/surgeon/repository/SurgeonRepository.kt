package com.example.mysurgeon.surgeon.repository

import com.example.mysurgeon.model.Surgeon
import com.example.mysurgeon.model.SurgeonDTO
import retrofit2.http.Query

interface SurgeonRepository {
    suspend fun getSurgeons(): List<Surgeon>
    suspend fun addOrEditSurgeon(
            mode: String,
            surgeonUniqueID: String?,
            firstName: String,
            lastName: String,
            hospital: String,
            specialization: String,
            contactPerson: String,
            workNo: String,
            mobileNo: String,
            mainNo: String,
            faxNo: String,
            multipleEmail: String,
            url: String,
            street: String,
            city: String,
            state: String,
            zip: String,
            notes: String
    )

        suspend fun viewSurgeon(surgeonUniqueID: String)
}