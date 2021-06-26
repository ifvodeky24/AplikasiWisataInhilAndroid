package com.example.wisata.data

import com.example.wisata.R
import com.example.wisata.models.Images

object ImagesData {

    private val imageNames = arrayOf(
        "Ulu Kasok",
        "Air Terjun Batang Kapas",
        "Tepian Mahligai",
        "Stanum Bangkinang",
        "Sungai Gulamo")

    private val imageDatas = intArrayOf(
        R.drawable.img_1,
        R.drawable.img_2,
        R.drawable.img_3,
        R.drawable.img_4,
        R.drawable.img_5
        )

    val listData: ArrayList<Images>
    get() {
        val list = arrayListOf<Images>()
        for (position in imageNames.indices){
            val data = Images()
            data.name = imageNames[position]
            data.photo = imageDatas[position]
            list.add(data)
        }
        return list
    }
}