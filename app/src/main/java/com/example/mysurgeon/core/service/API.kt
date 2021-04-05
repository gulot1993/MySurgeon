package com.example.mysurgeon.core.service

import com.example.mysurgeon.model.BaseResponse
import com.example.mysurgeon.model.LoginDTO
import com.example.mysurgeon.model.Surgeon
import com.example.mysurgeon.model.SurgeonDTO
import retrofit2.http.POST
import retrofit2.http.Query

interface API {
    @POST("api_test.php?")
    suspend fun login(@Query("mode") mode: String,
                      @Query("u") username: String,
                      @Query("p") password: String): LoginDTO

    @POST("api_test.php?")
    suspend fun getStates(@Query("mode") mode: String): List<String>

    @POST("api_test.php?")
    suspend fun register(
            @Query("mode") mode: String,
            @Query("promoCode") promoCode: String,
            @Query("firstName") firstName: String,
            @Query("lastName") lastName: String,
            @Query("email") email: String,
            @Query("username") username: String,
            @Query("password") password: String,
            @Query("retypedPassword") retypedPassword: String,
            @Query("street") street: String,
            @Query("state") state: String,
            @Query("city") city: String,
            @Query("zip") zip: String,
            @Query("mobileNo") mobileNo: String,
            @Query("landlineNo") landlineNo: String,
            @Query("email_update") email_update: String,
            @Query("iphone_update") iphone_update: String
    ): String

    @POST("api_test.php?")
    suspend fun getSurgeons(
            @Query("mode") mode: String,
            @Query("userID") userID: String
    ): List<SurgeonDTO>

    @POST("api_test.php?")
    suspend fun addSurgeon(
            @Query("mode") mode: String,
            @Query("accessToken") accessToken: String,
            @Query("userID") userID: String,
            @Query("firstName") firstName: String,
            @Query("lastName") lastName: String,
            @Query("hospital") hospital: String,
            @Query("specialization") specialization: String,
            @Query("contactPerson") contactPerson: String,
            @Query("workNo") workNo: String,
            @Query("mobileNo") mobileNo: String,
            @Query("mainNo") mainNo: String,
            @Query("faxNo") faxNo: String,
            @Query("multipleEmail") multipleEmail: String,
            @Query("url") url: String,
            @Query("street") street: String,
            @Query("city") city: String,
            @Query("state") state: String,
            @Query("zip") zip: String,
            @Query("notes") notes: String
    ): String

    @POST("api_test.php?")
    suspend fun editSurgeon(
        @Query("mode") mode: String,
        @Query("accessToken") accessToken: String,
        @Query("userID") userID: String,
        @Query("surgeonUniqueID") surgeonUniqueID: String,
        @Query("firstName") firstName: String,
        @Query("lastName") lastName: String,
        @Query("hospital") hospital: String,
        @Query("specialization") specialization: String,
        @Query("contactPerson") contactPerson: String,
        @Query("workNo") workNo: String,
        @Query("mobileNo") mobileNo: String,
        @Query("mainNo") mainNo: String,
        @Query("faxNo") faxNo: String,
        @Query("multipleEmail") multipleEmail: String,
        @Query("url") url: String,
        @Query("street") street: String,
        @Query("city") city: String,
        @Query("state") state: String,
        @Query("zip") zip: String,
        @Query("notes") notes: String
    ): String

    @POST("api_test.php?")
    suspend fun viewSurgeon(@Query("mode") mode: String,
                            @Query("surgeonUniqueID") surgeonUniqueID: String,
                            @Query("accessToken") accessToken: String,
                            @Query("userID") userID: String)

    @POST("api_test.php?")
    suspend fun addProcedure(@Query("mode") mode: String,
                             @Query("userID") userID: String,
                             @Query("procedureName") procedureName: String,
                             @Query("procedureCode") procedureCode: String,
                             @Query("vendor") vendor: String,
                             @Query("favIntruments") favIntruments: String,
                             @Query("positioning") positioning: String,
                             @Query("dressing") dressing: String,
                             @Query("woundClosure") woundClosure: String,
                             @Query("notes") notes: String,
                             @Query("switchCase") switchCase: String,
                             @Query("surgeonUniqueID") surgeonUniqueID: String,
                             @Query("accessToken") accessToken: String)

    @POST("api_test.php?")
    suspend fun editProcedure(@Query("mode") mode: String,
                             @Query("procedureUniqueID") procedureUniqueID: String,
                             @Query("userID") userID: String,
                             @Query("procedureName") procedureName: String,
                             @Query("procedureCode") procedureCode: String,
                             @Query("vendor") vendor: String,
                             @Query("favIntruments") favIntruments: String,
                             @Query("positioning") positioning: String,
                             @Query("dressing") dressing: String,
                             @Query("woundClosure") woundClosure: String,
                             @Query("notes") notes: String,
                             @Query("switchCase") switchCase: String,
                             @Query("surgeonUniqueID") surgeonUniqueID: String,
                             @Query("accessToken") accessToken: String)

    @POST("api_test.php?")
    suspend fun getNotification(@Query("mode") mode: String,@Query("timestamp") timestamp: String)

    @POST("api_test.php?")
    suspend fun addAppointment(@Query("mode") mode: String,
                               @Query("userID") userID: String,
                               @Query("location") location: String,
                               @Query("surgeonName") surgeonName: String,
                               @Query("selectedSurgeonName") selectedSurgeonName: String,
                               @Query("procedureUniqueID") procedureUniqueID: String,
                               @Query("selectedProcedudeName") selectedProcedudeName: String,
                               @Query("procedureName") procedureName: String,
                               @Query("notes") notes: String,
                               @Query("startDate") startDate: String,
                               @Query("startTime") startTime: String,
                               @Query("startPeriod") startPeriod: String,
                               @Query("endDate") endDate: String,
                               @Query("endTime") endTime: String,
                               @Query("endPeriod") endPeriod: String,
                               @Query("accessToken") accessToken: String)

    @POST("api_test.php?")
    suspend fun editAppointment(@Query("mode") mode: String,
                               @Query("userID") userID: String,
                               @Query("appointmentID") appointmentID: String,
                               @Query("location") location: String,
                               @Query("surgeonName") surgeonName: String,
                               @Query("selectedSurgeonName") selectedSurgeonName: String,
                               @Query("procedureUniqueID") procedureUniqueID: String,
                               @Query("selectedProcedudeName") selectedProcedudeName: String,
                               @Query("procedureName") procedureName: String,
                               @Query("notes") notes: String,
                               @Query("startDate") startDate: String,
                               @Query("startTime") startTime: String,
                               @Query("startPeriod") startPeriod: String,
                               @Query("endDate") endDate: String,
                               @Query("endTime") endTime: String,
                               @Query("endPeriod") endPeriod: String,
                               @Query("accessToken") accessToken: String)
}