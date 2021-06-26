package com.example.wisata.repositories

import com.example.wisata.responses.DestinasiResponse
import com.example.wisata.responses.JenisDestinasiResponse
import com.example.wisata.rest.WisataRest
import io.reactivex.Flowable

class DestinasiRepositoryImp(private val wisataRest : WisataRest) : DestinasiRepository {
    override fun getDestinasi(jenis: Int): Flowable<DestinasiResponse> = wisataRest.getDestinasi(jenis)
}