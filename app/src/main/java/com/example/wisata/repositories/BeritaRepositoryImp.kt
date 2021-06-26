package com.example.wisata.repositories

import com.example.wisata.responses.BeritaResponse
import com.example.wisata.responses.EventResponse
import com.example.wisata.responses.JenisDestinasiResponse
import com.example.wisata.rest.WisataRest
import io.reactivex.Flowable

class BeritaRepositoryImp(private val wisataRest : WisataRest) : BeritaRepository {
    override fun getBerita(): Flowable<BeritaResponse> = wisataRest.getBerita()
}