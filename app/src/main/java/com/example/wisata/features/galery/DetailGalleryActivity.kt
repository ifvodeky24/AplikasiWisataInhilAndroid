package com.example.wisata.features.galery

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.wisata.R
import com.example.wisata.config.ServerConfig
import com.example.wisata.features.destinasi.DestinasiActivity
import kotlinx.android.synthetic.main.activity_detail_gallery.*
import kotlinx.android.synthetic.main.gallery_item.view.*

class DetailGalleryActivity : AppCompatActivity() {

    private var imageGalerry: String? = null

    companion object {
        const val EXTRA_GALERRY = "extra_galerry"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_gallery)
        initToolbar()

        imageGalerry = intent.getStringExtra(EXTRA_GALERRY)

        Glide.with(this)
            .load(ServerConfig.GALLERY_PATH+imageGalerry)
            .apply(RequestOptions().placeholder(R.drawable.ic_hourglass_empty_black_24dp))
            .into(iv_gallery)
    }

    private fun initToolbar() {
        supportActionBar?.title = "Detail Gallery";
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}