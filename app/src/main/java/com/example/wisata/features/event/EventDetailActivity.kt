package com.example.wisata.features.event

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.wisata.R
import com.example.wisata.config.ServerConfig
import com.example.wisata.models.Event
import kotlinx.android.synthetic.main.activity_event_detail.*

class EventDetailActivity : AppCompatActivity() {

    lateinit var event: Event
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_detail)
        initToolbar()
        initIntent()
    }

    private fun initIntent() {
        event = intent.getParcelableExtra(EXTRA_EVENT)
        Glide.with(this)
            .load(ServerConfig.EVENT_PATH+event.gambar)
            .apply(RequestOptions().placeholder(R.drawable.ic_photo_black_24dp))
            .into(iv_gambar)
        tv_judul.text = event.judul
        tv_tanggal.text = event.createdAt
        tv_isi.text = event.isi
    }

    private fun initToolbar() {
        supportActionBar?.title = "Detail Event";
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val EXTRA_EVENT = "extra_event"
    }

}
