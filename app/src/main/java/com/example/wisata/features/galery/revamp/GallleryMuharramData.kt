package com.example.wisata.features.galery.revamp

import com.example.wisata.R
import com.example.wisata.models.Galleries

object GallleryMuharramData {
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
        R.drawable.muharram_1,
        R.drawable.muharram_2,
        R.drawable.muharram_3,
        R.drawable.muharram_4,
        R.drawable.muharram_5,
        R.drawable.muharram_6,
        R.drawable.muharram_7,
        R.drawable.muharram_8,
        R.drawable.muharram_9,
        R.drawable.muharram_10,
        R.drawable.muharram_11
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