package com.example.mysurgeon.model

import kotlinx.android.parcel.Parcelize

@Parcelize
class SurgeonDTO(
        var SurgeonUniqueID: String,
        var UserID: String,
        var FirstName: String,
        var LastName: String,
        var Hospital: String,
        var Specialization: String,
        var ContactPerson: String,
        var WorkNo: String,
        var MobileNo: String,
        var MainNo: String,
        var FaxNo: String,
        var EMail: String,
        var URL: String,
        var Street: String,
        var City: String,
        var State: String,
        var Zip: String,
        var Notes: String,
        var SharedContextToken: String,
        var SharedViewed: String,
        var SharedAccepted: String,
        var SenderFullName: String,
        var SenderUserID: String,
        var LastUpdated: String,
        var SurgeonName: String,
        var surgeonImg: String): Model()