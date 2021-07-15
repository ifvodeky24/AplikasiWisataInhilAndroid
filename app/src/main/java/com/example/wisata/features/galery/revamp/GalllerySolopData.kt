package com.example.wisata.features.galery.revamp

import com.example.wisata.R
import com.example.wisata.models.Galleries

object GalllerySolopData {
    private val id = arrayOf(
        "1",
        "2",
        "3",
        "4",
        "5",
        "6"
    )

    private val image = intArrayOf(
        R.drawable.solop_1,
        R.drawable.solop_2,
        R.drawable.solop_3,
        R.drawable.solop_4,
        R.drawable.solop_5,
        R.drawable.solop_6
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