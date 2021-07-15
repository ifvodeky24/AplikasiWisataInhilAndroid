package com.example.wisata.features.event.revamp

import com.example.wisata.R
import com.example.wisata.models.Events

object EventReligiData {
    private val id = arrayOf(
        "1",
        "2",
        "3",
        "4",
        "5"
    )

    private val name = arrayOf(
        "Gema Muharram",
        "Grebeg Suro",
        "Milad Inhil",
        "Pawai Ta'ruf",
        "Semah Kampung Planduk"
    )

    private val description = arrayOf(
        "Dalam rangka memperingati hari besar islam, Pemerintah Kabupaten Indragiri Hilir melalui Dinas Pemuda, Olahraga, Kebudayaan dan Pariwisata menyelenggarakan sebuah kegiatan yang bertajuk Event Wisata Religi Gema Muharram. Event ini setiap tahunnya terus dilaksanakan, meningkatkan kegiatan ini sangat bernilai positif untuk masyarakat Kabupaten Indragiri Hilir. Dalam Event ini beberapa kegiatan yang bersifat religius dilaksanakan. \n\n- Pawai Ta’aruf Menyambut 1 Muharram\n- Do’a Akhir Tahun dan Do’a Awal Tahun Hijriah\n- Tablik Akbar Menyambut Tahun Baru Hijriah",
        "Adalah salah satu budaya jawa Islam yang berkembang dengan baik ditanah Indragiri Hilir kebudayaan ini dibawa oleh pendatang transmigrasi dari tanah jawa yang sejak dahulu telah menjadi bagian yang tak terpisahkan dari masyarakat lndragiri Hilir.\n\nPuncak dari upacara ini adalah iringan tumpeng dengan dihiasi basil tani masyarakat setempat dan diselenggarakan do’a dan upacara persembahan kahadirat Allah SWT, setelah selesai pembacaan do’a tumpeng beserta hiasannya diperebutkan masyarakat sekitar yang menyaksikan acara ini, grebeg suro ini diselenggarakan pada bulan suro/muharram pada setiap tahunnya.",
        "Milad Kabupaten Indragiri Hilir adalah hari jadi ataupun hari berdirinya Kabupaten Indragiri Hilir yang diperingati pada bulan juni setiap tahunnya, yakni tepatnya pada tanggal 14 juni 1965 lalu.\n\nSebagai daerah yang agamais, heterogen dan berkembang perayaan milad selalu digelar dengan berbagai kegiatan seperti tablik akbar, olahraga, atraksi dan permainan rakyat banyak menjadi perhatian masyarakat maupun pengunjung yang datang ke lndragiri Hilir.",
        "Pawai Ta’ruf adalah parade iringan peserta takbiran hari raya idul fitri ataupun idul adha yang menampilkan berbagai seni dan kebudayaan islam lewat pakaian, kendaraan hias, miniature masjid dan pernak-pernik lainnya. Disepanjang perjalanan, mereka melafazkan Takbir, tauhid sebagai tanda kebesaran lstam aktifitas ini menjadi lebih menarik karena dihiasi lampu-lampu gemerlap ditengah kota Tembilahan. Pemandangan ini menjadi lebih mengasikan karena tidak saja umat islam yang bergembira pada malam itu, akan tetapi seluruh warga Indragiri Hilir juga menikmatinya bersama Islam is Rahmatalil'alamim ",
        "Upacara Semah Kampung merupakan event budaya tradisional masyarakat desa planduk yang pada setiap tahunnya dilaksanakan sebagai perwujudan rasa syukur atas kekayaan laut yang selalu mencukupi kebutuhan masyarakat setempat. Upacara yang dapat menarik wisatawan ini dirayakan oleh penduduk desa Planduk setiap tahunnya perayaan ini cukup sarat dengan unsur - unsur budaya dan memiliki nilai - nilai religius yang tinggi. \n\nBila ingin melihat upacara yang tidak akan pernah dijumpai ditempat lain tersebut maka dengan menggunakan speed boat, lokasi desa Planduk dapat dicapai dalam waktu sekitar 30 manit apabila berangkat dari Kecamatan Mandah."
    )

    private val image = intArrayOf(
        R.drawable.muharram_1,
        R.drawable.event_religi_2_grebeg_suro,
        R.drawable.event_religi_3_milad_inhil,
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