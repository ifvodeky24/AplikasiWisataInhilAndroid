package com.example.wisata.features.galery.revamp

import com.example.wisata.R
import com.example.wisata.models.Galleries

object GallleryLeperData {
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
        "10"
    )

    private val image = intArrayOf(
        R.drawable.leper_1,
        R.drawable.leper_2,
        R.drawable.leper_3,
        R.drawable.leper_4,
        R.drawable.leper_5,
        R.drawable.leper_6,
        R.drawable.leper_7,
        R.drawable.leper_8,
        R.drawable.leper_9,
        R.drawable.leper_10
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