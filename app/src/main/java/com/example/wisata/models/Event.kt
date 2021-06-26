package com.example.wisata.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Event(
    @SerializedName("id") var id: String?,
    @SerializedName("judul") var judul: String?,
    @SerializedName("isi") var isi: String?,
    @SerializedName("gambar") var gambar: String?,
    @SerializedName("createdAt") var createdAt: String?
    ) : Parcelable