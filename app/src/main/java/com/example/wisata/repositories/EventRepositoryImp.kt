package com.example.wisata.repositories

import com.example.wisata.responses.EventResponse
import com.example.wisata.responses.JenisDestinasiResponse
import com.example.wisata.rest.WisataRest
import io.reactivex.Flowable

class EventRepositoryImp(private val wisataRest : WisataRest) : EventRepository {
    override fun getEvent(): Flowable<EventResponse> = wisataRest.getEvent()
}