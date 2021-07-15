package com.example.wisata.features.galery.revamp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wisata.R
import com.example.wisata.adapter.JenisGalleryAdapter
import com.example.wisata.models.JenisGallery
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_jenis_gallery.*

class JenisGalleryActivity : AppCompatActivity() {
    private var list: ArrayList<JenisGallery> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jenis_gallery)

        rv_jenis_gallery.setHasFixedSize(true)

        list.addAll(JenisGalleryData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {

        Log.d("sdsdsd", Gson().toJson(list))
        rv_jenis_gallery.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = JenisGalleryAdapter(list, this)
        rv_jenis_gallery.adapter = listHeroAdapter
    }
}