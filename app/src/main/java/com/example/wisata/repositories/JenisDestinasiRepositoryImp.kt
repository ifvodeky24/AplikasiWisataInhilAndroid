package com.example.wisata.repositories

import com.example.wisata.responses.JenisDestinasiResponse
import com.example.wisata.rest.WisataRest
import io.reactivex.Flowable

class JenisDestinasiRepositoryImp(private val wisataRest : WisataRest) : JenisDestinasiRepository {
    override fun getJenisDestinasi(): Flowable<JenisDestinasiResponse> = wisataRest.getJenisDestinasi()
}