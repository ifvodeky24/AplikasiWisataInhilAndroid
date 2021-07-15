package com.example.wisata.features.galery.revamp

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wisata.R
import com.example.wisata.adapter.GalleriesAdapter
import com.example.wisata.models.Galleries
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_galleries.*

class GalleriesActivity : AppCompatActivity() {
    private var list: ArrayList<Galleries> = arrayListOf()
    var id: String = ""

    companion object {
        var EXTRA_ID = "extra_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_galleries)
        initToolbar()

        id = intent.getStringExtra(EXTRA_ID)
        Log.d("buum", id)

        rvGallery.setHasFixedSize(true)
        when (id) {
            "1" -> {
                list.addAll(Galllery86Data.listData)
            }
            "2" -> {
                list.addAll(GallleryMuharramData.listData)
            }
            "3" -> {
                list.addAll(GalllerySolopData.listData)
            }
            "4" -> {
                list.addAll(GallleryMenongkahData.listData)
            }
            "5" -> {
                list.addAll(GallleryLeperData.listData)
            }
            "6" -> {
                list.addAll(GalllerySelodangData.listData)
            }
        }

        showRecyclerList()
    }

    private fun showRecyclerList() {
        Log.d("sdsdsd", Gson().toJson(list))
        rvGallery.layoutManager = GridLayoutManager(this, 2)
        val listHeroAdapter = GalleriesAdapter(list, this)
        rvGallery.adapter = listHeroAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initToolbar() {
        supportActionBar?.title = "Galeri";
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}