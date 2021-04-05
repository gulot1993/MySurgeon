package com.example.mysurgeon.model

import kotlinx.android.parcel.Parcelize

@Parcelize
class Surgeon(
              var SurgeonUniqueID: String? = null,
              var UserID: String? = null,
              var FirstName: String? = null,
              var LastName: String? = null,
              var Hospital: String? = null,
              var Specialization: String? = null,
              var ContactPerson: String? = null,
              var WorkNo: String? = null,
              var MobileNo: String? = null,
              var MainNo: String? = null,
              var FaxNo: String? = null,
              var EMail: String? = null,
              var URL: String? = null,
              var location: String? = null,
              var Notes: String? = null,
              var SharedContextToken: String? = null,
              var SharedViewed: String? = null,
              var SharedAccepted: String? = null,
              var SenderFullName: String? = null,
              var SenderUserID: String? = null,
              var LastUpdated: String? = null,
              var SurgeonName: String? = null,
              var surgeonImg: String? = null,
              var Street: String? = null,
              var Zip: String? = null,
              var State: String? = null,
              var City: String? = null,
              var isHeader: Boolean = false): Model()