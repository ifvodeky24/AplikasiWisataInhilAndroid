package com.example.wisata.responses

import com.example.wisata.models.Destinasi
import com.example.wisata.models.JenisDestinasi
import com.google.gson.annotations.SerializedName

data class JenisDestinasiResponse(
    @SerializedName("jenis_destinasi") var jenis_destinasi: List<JenisDestinasi>
)