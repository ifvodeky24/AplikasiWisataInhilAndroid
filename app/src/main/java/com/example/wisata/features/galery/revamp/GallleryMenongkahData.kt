package com.example.wisata.features.galery.revamp

import com.example.wisata.R
import com.example.wisata.models.Galleries

object GallleryMenongkahData {
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
        R.drawable.manongkah_1,
        R.drawable.manongkah_2,
        R.drawable.manongkah_3,
        R.drawable.manongkah_4,
        R.drawable.manongkah_5,
        R.drawable.manongkah_6,
        R.drawable.manongkah_7,
        R.drawable.manongkah_8,
        R.drawable.manongkah_9,
        R.drawable.manongkah_10
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