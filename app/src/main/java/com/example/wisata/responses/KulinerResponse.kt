package com.example.wisata.responses

import com.example.wisata.models.*
import com.google.gson.annotations.SerializedName

data class KulinerResponse(
    @SerializedName("kuliner") var kuliner: List<Kuliner>
)