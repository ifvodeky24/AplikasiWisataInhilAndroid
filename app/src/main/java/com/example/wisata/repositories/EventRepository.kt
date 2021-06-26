package com.example.wisata.repositories

import com.example.wisata.responses.DestinasiResponse
import com.example.wisata.responses.EventResponse
import com.example.wisata.responses.JenisDestinasiResponse
import io.reactivex.Flowable

interface EventRepository {
    fun getEvent() : Flowable<EventResponse>
}