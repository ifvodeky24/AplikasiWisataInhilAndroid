package com.example.wisata.features.galery.revamp

import com.example.wisata.R
import com.example.wisata.models.Galleries

object GalllerySelodangData {
    private val id = arrayOf(
        "1",
        "2",
        "3",
        "4"
    )

    private val image = intArrayOf(
        R.drawable.selodang_1,
        R.drawable.selodang_2,
        R.drawable.selodang_3,
        R.drawable.selodang_4
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