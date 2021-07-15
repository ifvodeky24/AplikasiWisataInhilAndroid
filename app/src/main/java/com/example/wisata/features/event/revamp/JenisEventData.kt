package com.example.wisata.features.event.revamp

import com.example.wisata.R
import com.example.wisata.models.JenisEvent

object JenisEventData {
    private val id = arrayOf(
        "1",
        "2"
    )

    private val jenisEvent = arrayOf(
        "Religi",
        "Wisata"
    )

    private val image = intArrayOf(
        R.drawable.manongkah_4,
        R.drawable.event_religi_1_gema_muharram
    )

    val listData: ArrayList<JenisEvent>
        get() {
            val list = arrayListOf<JenisEvent>()
            for (position in id.indices) {
                val jenisEvent = JenisEvent()
                jenisEvent.id = id[position]
                jenisEvent.jenisEvent = JenisEventData.jenisEvent[position]
                jenisEvent.image = image[position]
                list.add(jenisEvent)
            }
            return list
        }
}