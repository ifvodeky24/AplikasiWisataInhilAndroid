package com.example.wisata.repositories

import com.example.wisata.responses.*
import io.reactivex.Flowable

interface KulinerRepository {
    fun getKuliner() : Flowable<KulinerResponse>
}