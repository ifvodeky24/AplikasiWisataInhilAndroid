package com.example.wisata.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class JenisDestinasi(
    @SerializedName("id") var id: String?,
    @SerializedName("jenis_destinasi") var jenis_destinasi: String?,
    @SerializedName("icon") var icon: String?
    ) : Parcelable