package com.example.wisata.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class JenisGallery(
    var id :String = "",
    var jenisGallery: String = "",
    var image: Int = 0
)