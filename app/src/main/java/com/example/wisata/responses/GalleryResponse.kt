package com.example.wisata.responses

import com.example.wisata.models.Destinasi
import com.example.wisata.models.Event
import com.example.wisata.models.Gallery
import com.example.wisata.models.JenisDestinasi
import com.google.gson.annotations.SerializedName

data class GalleryResponse(
    @SerializedName("gallery") var gallery: List<Gallery>
)