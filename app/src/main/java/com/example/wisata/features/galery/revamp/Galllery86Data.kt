package com.example.wisata.features.galery.revamp

import com.example.wisata.R
import com.example.wisata.models.Galleries

object Galllery86Data {
    private val id = arrayOf(
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "10",
        "11"
    )

    private val image = intArrayOf(
        R.drawable.gallery_86_1,
        R.drawable.gallery_86_2,
        R.drawable.gallery_86_3,
        R.drawable.gallery_86_4,
        R.drawable.gallery_86_5,
        R.drawable.gallery_86_7,
        R.drawable.gallery_86_9,
        R.drawable.gallery_86_10,
        R.drawable.gallery_86_11,
        R.drawable.gallery_86_12,
        R.drawable.gallery_86_13
    )

    val listData: ArrayList<Galleries>
        get() {
            val list = arrayListOf<Galleries>()
            for (position in id.indices) {
                val galleries = Galleries()
                galleries.id = id[position]
                galleries.image = image[position]
                list.add(galleries)
            }
            return list
        }
}