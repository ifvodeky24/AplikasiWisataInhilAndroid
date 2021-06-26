package com.example.wisata.features.destinasi

import com.example.wisata.models.Destinasi

interface DestinasiContract {
    interface View {
        fun hideLoading()
        fun showLoading()
        fun displayDestinasi(destinasi: List<Destinasi>)
    }
    interface Presenter{
        fun getDestinasiData(jenis: Int)
        fun onDestroyPresenter()
    }
}