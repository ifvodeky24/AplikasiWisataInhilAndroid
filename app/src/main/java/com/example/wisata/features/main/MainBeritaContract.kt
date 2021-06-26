package com.example.wisata.features.main

import com.example.wisata.models.Berita
import com.example.wisata.models.Destinasi
import com.example.wisata.models.Event

interface MainBeritaContract {
    interface View {
        fun hideLoading()
        fun showLoading()
        fun displayBerita(berita: List<Berita>)
    }
    interface Presenter{
        fun getBeritaData()
        fun onDestroyPresenter()
    }
}