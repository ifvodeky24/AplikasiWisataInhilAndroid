package com.example.wisata.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Destinasi(
    @SerializedName("id") var id: String?,
    @SerializedName("nama") var nama: String?,
    @SerializedName("deskripsi") var deskripsi: String?,
    @SerializedName("jenis_id") var jenis_id: String?,
    @SerializedName("alamat") var alamat: String?,
    @SerializedName("no_hp") var no_hp: String?,
    @SerializedName("website") var website: String?,
    @SerializedName("ig") var ig: String?,
    @SerializedName("fb") var fb: String?,
    @SerializedName("yt") var yt: String?,
    @SerializedName("jam_buka") var jam_buka: String?,
    @SerializedName("lat") var lat: String?,
    @SerializedName("lng") var lng: String?,
    @SerializedName("photo") var photo: String?
    ) : Parcelable