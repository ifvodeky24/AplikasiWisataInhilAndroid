package com.example.wisata.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Galleries(
    var id: String = "",
    var image: Int = 0
) : Parcelable