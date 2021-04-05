package com.example.mysurgeon.procedure.repository

import retrofit2.http.Query

interface ProcedureRepository {
    suspend fun addOrEditProcedure(
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
    )
}