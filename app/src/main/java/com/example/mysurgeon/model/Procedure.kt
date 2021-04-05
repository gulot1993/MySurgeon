package com.example.mysurgeon.model

import kotlinx.android.parcel.Parcelize

@Parcelize
data class Procedure(var name: String,
                     var linkedSurgeon: Int,
                     var unlinkedSurgeon: Int,
                     var isHeader: Boolean): Model()