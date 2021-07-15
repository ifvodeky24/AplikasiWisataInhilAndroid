package com.example.wisata.features.galery.revamp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.example.wisata.R
import com.example.wisata.models.Galleries
import kotlinx.android.synthetic.main.activity_detail_galleries.*

class DetailGalleriesActivity : AppCompatActivity() {
    private var galleries: Galleries? = null

    companion object {
        const val EXTRA_GALERRY = "extra_galerry"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_galleries)

        galleries = intent.getParcelableExtra(EXTRA_GALERRY)
        initToolbar()

        Glide.with(this)
            .load(galleries!!.image)
            .into(iv_gallery)
    }

    private fun initToolbar() {
        supportActionBar?.title = "Detail Galeri";
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}