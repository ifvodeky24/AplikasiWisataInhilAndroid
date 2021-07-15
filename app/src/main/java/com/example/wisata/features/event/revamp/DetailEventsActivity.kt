package com.example.wisata.features.event.revamp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.example.wisata.R
import com.example.wisata.models.Events
import kotlinx.android.synthetic.main.activity_event_detail.*

class DetailEventsActivity : AppCompatActivity() {
    lateinit var event: Events

    companion object {
        const val EXTRA_EVENT = "extra_event"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_events)
        initToolbar()
        initIntent()
    }

    private fun initIntent() {
        event = intent.getParcelableExtra(EXTRA_EVENT)
        Glide.with(this)
            .load(event.image)
            .into(iv_gambar)
        tv_judul.text = event.name
//        tv_tanggal.text = event.createdAt
        tv_isi.text = event.description
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
}