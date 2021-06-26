package com.example.wisata.features.jenisdestinasi

import com.example.wisata.models.JenisDestinasi

interface JenisDestinasiContract {
    interface View {
        fun hideLoading()
        fun showLoading()
        fun displayJenisDestinasi(jenisDestinasiList: List<JenisDestinasi>)
    }
    interface Presenter{
        fun getJenisDestinasiData()
        fun onDestroyPresenter()
    }
}