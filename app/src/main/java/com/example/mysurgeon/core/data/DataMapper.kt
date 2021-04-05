package com.example.mysurgeon.core.data

import com.example.mysurgeon.model.Login
import com.example.mysurgeon.model.LoginDTO
import com.example.mysurgeon.model.Surgeon
import com.example.mysurgeon.model.SurgeonDTO

fun LoginDTO.toLogin(): Login = Login(
        userID = userID,
        accessToken = accessToken,
        paymentOption = paymentOption,
        expiryLastShown = expiryLastShown)

fun SurgeonDTO.toSurgeon(): Surgeon = Surgeon(
        SurgeonUniqueID = SurgeonUniqueID,
        FirstName = FirstName,
        LastName = LastName,
        location = "$Street, $City",
        surgeonImg = surgeonImg,
        Hospital = Hospital,
        FaxNo = FaxNo,
        ContactPerson = ContactPerson,
        MainNo = MainNo,
        EMail = EMail,
        WorkNo = WorkNo,
        MobileNo = MobileNo,
        URL = URL,
        Notes = Notes,
        Zip = Zip,
        State = State,
        Street = Street,
        Specialization = Specialization,
        City = City
)