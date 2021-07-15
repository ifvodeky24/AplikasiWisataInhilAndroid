package com.example.wisata.features.event.revamp

import com.example.wisata.R
import com.example.wisata.models.Events

object EventWisataData {
    private val id = arrayOf(
        "1",
        "2",
        "3"
    )

    private val name = arrayOf(
        "Menongkah",
        "Pacu Sampan Leper",
        "Pacu Sampan Slodang",
        "Pawai Ta'ruf",
        "Semah Kampung Planduk"
    )

    private val description = arrayOf(
        "Menongkah merupakan tradisi unik yang masih dilakukan oleh sebahagian masyarakat Suku Duanu di Kecamatan Concong. Menongkah sudah menjadi kegiatan turun temurun yang dilakukan Suku Duano. Dari catatan sejarah, Suku Duano atau Orang Laut termasuk RAS PROTO MALAY (Golongan Melayu Tua) di Riau. Suku ini sudah ada sejak tahun 2500 SM 5/ d 1500 SM.\n\nDulu mereka disebut Suku Anak Laut yang berdiam di pinggir pantai atau di teluk-teluk di pesisir Timur lndragiri Hilir. Suku ini termasuk suku nomaden, artinya mereka suka berpindah-pindah dari satu tempat ke tempat lain, dari satu pulau ke pulau Iain, atau dari satu ceruk ke ceruk lain. Kebudayaan menongkah itu merupakan warisan budaya dunia. Menongkah ini merupakan asli kebudayaan lndragiri Hilir. Kebudayaan menongkah di kemas dalam sebuah Event Wisata tahunan kabupaten indragiri Hilir. Concong merupakan salah satu daerah yang terletak dibibir taut sehingga Kecamatan ini dijuluki daerah penghasil ikan terbesar di Kabupaten lndragiri Hilir, berjarak tempuh 1,5 jam dari lbukota Kabupaten Indragiri Hilir.",
        "Sampan Leper merupakan perahu kecii yang berisi 2-4 penumpang yang dapat berjalan diatas lumpur dan air, pacu sampan leper merupakan salah satu event tahunan yang menjadi favorit masyarakat Kabupaten lndragiri Hilir. Event ini dilaksanakan kisaran bulan Juni s.d Agustus (menyesuaikan kondisi alam), dilaksanakan di Lokasi Pacu Sampan Leper Kuala Getek Keluharan Sungai Beringin Tembilahan. lokasi ini tidak jauh dari lbukota Kabupaten lndragiri Hilir, yaitu Kota Tembilahan. Kurang lebih 15 menit dari Kota Tembilahan menuju lokasi tersebut. Pacu Sampan Leper merupakan salah satu budaya masyarakat inhil sebagai bentuk pelestarian kebudayaan. Dahulunya Sampan ini dipergunakan sebagai alat transportasi massal karena lndragiri Hilir merupakan Daerah Pasang Surut, sehingga dengan adanya sampan ini dapat memecah permasalahan masyarakat di Kabupaten lndragiri Hilir.",
        "Pacu Sampan Slodang atau sering disebut Lombe’ Slodang merupakan suatu Event Wisata Kabupaten indragiri Hilir yang dilaksanakan di Kecamatan Gaung. Slodang adalah sebuah perahu kecil panjang yang berisi 8 orang penumpang, Slodang berasal dari kata - kata orang tua dahulu. Kegiatan ini dilaksanakan sebagai wujud pelestarian budaya dan tradisi leluhur. Lombe’ Slodang ini diadakan diatas sungai gaung yang merupakan jalur trasportasi Ibukota dengan daerah - daerah lain, untuk dapat menyaksikan Event ini, wisatawan dapat menempuh Perjalanan sungai menawan dengan waktu tebih kurang 1 jam dari lbukota Kabupaten lndragiri Hilir dengan menggunakan trasportasi air (sped Boat)."
    )

    private val image = intArrayOf(
        R.drawable.manongkah_4,
        R.drawable.leper_1,
        R.drawable.selodang_1,
        R.drawable.event_religi_4_pawai_taaruf,
        R.drawable.event_religi_semah_planduk
    )

    val listData: ArrayList<Events>
        get() {
            val list = arrayListOf<Events>()
            for (position in id.indices) {
                val events = Events()
                events.id = id[position]
                events.name = name[position]
                events.description = description[position]
                events.image = image[position]
                list.add(events)
            }
            return list
        }
}