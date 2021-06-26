package com.example.wisata.repositories

import com.example.wisata.responses.DestinasiResponse
import com.example.wisata.responses.JenisDestinasiResponse
import io.reactivex.Flowable

interface JenisDestinasiRepository {
    fun getJenisDestinasi() : Flowable<JenisDestinasiResponse>
}