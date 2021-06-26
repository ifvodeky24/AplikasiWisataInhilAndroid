package com.example.wisata.repositories

import com.example.wisata.responses.DestinasiResponse
import com.example.wisata.responses.JenisDestinasiResponse
import com.example.wisata.rest.WisataRest
import io.reactivex.Flowable

class DestinasiMapRepositoryImp(private val wisataRest : WisataRest) : DestinasiMapRepository {
    override fun getDestinasiMap(): Flowable<DestinasiResponse> = wisataRest.getDestinasiMap()
}