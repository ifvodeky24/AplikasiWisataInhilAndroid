package com.example.wisata.features.berita

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.wisata.R
import com.example.wisata.config.ServerConfig
import com.example.wisata.models.Berita
import kotlinx.android.synthetic.main.activity_berita_detail.*

class BeritaDetailActivity : AppCompatActivity() {
    lateinit var berita: Berita
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_berita_detail)
        initToolbar()
        initIntent()
    }

    private fun initIntent() {
        berita = intent.getParcelableExtra(EXTRA_BERITA)
        Glide.with(this)
            .load(ServerConfig.BERITA_PATH+berita.gambar)
            .apply(RequestOptions().placeholder(R.drawable.ic_photo_black_24dp))
            .into(iv_gambar)
        tv_judul.text = berita.judul
        tv_tanggal.text = berita.createdAt
        tv_isi.text = berita.isi
    }

    private fun initToolbar() {
        supportActionBar?.title = "Detail Berita";
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val EXTRA_BERITA = "extra_berita"
    }
}
