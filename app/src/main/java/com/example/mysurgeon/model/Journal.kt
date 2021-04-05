package com.example.mysurgeon.model

data class Journal(var procedure: String,
                   var surgeon: String,
                   var startDate: String,
                   var endDate: String,
                   var type: String)