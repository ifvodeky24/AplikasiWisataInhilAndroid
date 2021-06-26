package com.example.wisata.features.kuliner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.wisata.R
import com.example.wisata.config.ServerConfig
import com.example.wisata.models.Kuliner
import kotlinx.android.synthetic.main.activity_kuliner_detail.*

class KulinerDetailActivity : AppCompatActivity() {
    lateinit var kuliner: Kuliner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kuliner_detail)
        initToolbar()
        initIntent()
    }

    private fun initToolbar() {
        supportActionBar?.title = "Detail Kuliner";
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initIntent() {
        kuliner = intent.getParcelableExtra(EXTRA_KULINER)
        Glide.with(this)
            .load(ServerConfig.KULINER_PATH+kuliner.gambar)
            .apply(RequestOptions().placeholder(R.drawable.ic_photo_black_24dp))
            .into(iv_gambar)
        tv_judul.text = kuliner.judul
        tv_tanggal.text = kuliner.createdAt
        tv_isi.text = kuliner.isi
    }

    companion object {
        const val EXTRA_KULINER = "extra_kuliner"
    }
}
