package com.example.wisata.features.galery.revamp

import com.example.wisata.R
import com.example.wisata.models.JenisGallery

object JenisGalleryData {
    private val id = arrayOf(
        "1",
        "2",
        "3",
        "4",
        "5",
        "6"
    )

    private val jenisGallery = arrayOf(
        "Air Terjun 86",
        "Gema Muharram",
        "Ekowisata Solop",
        "Menongkah",
        "Sampan Leper",
        "Sampan Selodang"
    )

    private val image = intArrayOf(
        R.drawable.gallery_86_1,
        R.drawable.muharram_1,
        R.drawable.solop_1,
        R.drawable.manongkah_1,
        R.drawable.leper_1,
        R.drawable.selodang_1
    )

    val listData: ArrayList<JenisGallery>
        get() {
            val list = arrayListOf<JenisGallery>()
            for (position in id.indices) {
                val jenisGallery = JenisGallery()
                jenisGallery.id = id[position]
                jenisGallery.jenisGallery = this.jenisGallery[position]
                jenisGallery.image = image[position]
                list.add(jenisGallery)
            }
            return list
        }
}