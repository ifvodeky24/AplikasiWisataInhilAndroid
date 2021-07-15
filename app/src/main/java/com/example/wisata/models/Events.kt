package com.example.wisata.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Events(
    var id: String = "",
    var name: String = "",
    var description: String = "",
    var image: Int = 0
) : Parcelable