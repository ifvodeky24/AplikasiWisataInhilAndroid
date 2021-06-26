package com.example.wisata.rest

import com.example.wisata.responses.*
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

interface WisataRest {

    @GET("destinasi")
    fun getDestinasiMap() : Flowable<DestinasiResponse>

    @GET("destinasi/{jenis}")
    fun getDestinasi(@Path("jenis") jenis:Int) : Flowable<DestinasiResponse>

    @GET("jenisdestinasi")
    fun getJenisDestinasi() : Flowable<JenisDestinasiResponse>

    @GET("event")
    fun getEvent() : Flowable<EventResponse>

    @GET("berita")
    fun getBerita() : Flowable<BeritaResponse>

    @GET("kuliner")
    fun getKuliner() : Flowable<KulinerResponse>

    @GET("gallery")
    fun getGallery() : Flowable<GalleryResponse>
}