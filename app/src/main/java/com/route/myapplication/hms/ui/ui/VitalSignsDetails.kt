package com.route.myapplication.hms.ui.ui

import java.util.*

data class VitalSignsDetails(
    val Date:String,
    val Time : String,
    val Weight:Int,
    val BloodPressure : Int,
    val PulseRate :Int,
    val Temperature :Int,
    val RespiratoryRate : Int,
    val Signature : String,
    val Comments: String
)
