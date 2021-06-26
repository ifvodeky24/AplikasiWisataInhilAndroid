package com.example.wisata.repositories

import com.example.wisata.responses.BeritaResponse
import com.example.wisata.responses.EventResponse
import com.example.wisata.responses.JenisDestinasiResponse
import com.example.wisata.responses.KulinerResponse
import com.example.wisata.rest.WisataRest
import io.reactivex.Flowable

class KulinerRepositoryImp(private val wisataRest : WisataRest) : KulinerRepository {
    override fun getKuliner(): Flowable<KulinerResponse> = wisataRest.getKuliner()
}