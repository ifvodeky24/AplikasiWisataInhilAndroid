package com.example.wisata.features.event

import com.example.wisata.models.Destinasi
import com.example.wisata.models.Event

interface EventContract {
    interface View {
        fun hideLoading()
        fun showLoading()
        fun displayEvent(event: List<Event>)
    }
    interface Presenter{
        fun getEventData()
        fun onDestroyPresenter()
    }
}