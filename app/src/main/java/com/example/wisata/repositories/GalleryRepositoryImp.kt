package com.example.wisata.repositories

import com.example.wisata.responses.EventResponse
import com.example.wisata.responses.GalleryResponse
import com.example.wisata.responses.JenisDestinasiResponse
import com.example.wisata.rest.WisataRest
import io.reactivex.Flowable

class GalleryRepositoryImp(private val wisataRest : WisataRest) : GalleryRepository {
    override fun getGallery(): Flowable<GalleryResponse> = wisataRest.getGallery()
}