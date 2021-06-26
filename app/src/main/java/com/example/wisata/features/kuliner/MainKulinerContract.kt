package com.example.wisata.features.kuliner

import com.example.wisata.models.Berita
import com.example.wisata.models.Destinasi
import com.example.wisata.models.Event
import com.example.wisata.models.Kuliner

interface MainKulinerContract {
    interface View {
        fun hideLoading()
        fun showLoading()
        fun displayKuliner(kuliner: List<Kuliner>)
    }
    interface Presenter{
        fun getKulinerData()
        fun onDestroyPresenter()
    }
}