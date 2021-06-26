package com.example.wisata.features.destinasi

import com.example.wisata.models.Destinasi

interface DestinasiMapContract {
    interface View {
        fun displayDestinasi(destinasi: List<Destinasi>)
    }
    interface Presenter{
        fun getDestinasiMapData()
        fun onDestroyPresenter()
    }
}