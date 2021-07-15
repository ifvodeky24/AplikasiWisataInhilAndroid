package com.example.wisata.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class JenisEvent(
    var id :String = "",
    var jenisEvent: String = "",
    var image: Int = 0
)
