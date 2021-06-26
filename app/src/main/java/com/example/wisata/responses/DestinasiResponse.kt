package com.example.wisata.responses

import com.example.wisata.models.Destinasi
import com.google.gson.annotations.SerializedName

data class DestinasiResponse(
    @SerializedName("destinasi") var destinasi: List<Destinasi>
)