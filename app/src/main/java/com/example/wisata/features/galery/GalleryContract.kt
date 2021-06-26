package com.example.wisata.features.galery

import com.example.wisata.models.Destinasi
import com.example.wisata.models.Event
import com.example.wisata.models.Gallery

interface GalleryContract {
    interface View {
        fun hideLoading()
        fun showLoading()
        fun displayGallery(gallery: List<Gallery>)
    }
    interface Presenter{
        fun getGalleryData()
        fun onDestroyPresenter()
    }
}