package com.example.wisata.features.event.revamp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wisata.R
import com.example.wisata.adapter.EventsAdapter
import com.example.wisata.adapter.JenisEventAdapter
import com.example.wisata.models.Events
import com.example.wisata.models.JenisEvent
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_events.*
import kotlinx.android.synthetic.main.activity_jenis_event.*

class EventsActivity : AppCompatActivity() {
    private var list: ArrayList<Events> = arrayListOf()
    var id: String = ""

    companion object {
        var EXTRA_ID = "extra_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)
        initToolbar()

        id = intent.getStringExtra(EXTRA_ID)
        Log.d("buum",  id)

        rvEvent.setHasFixedSize(true)

        if (id == "1"){
            list.addAll(EventReligiData.listData)
        } else {
            list.addAll(EventWisataData.listData)
        }

        showRecyclerList()
    }

    private fun initToolbar() {
        supportActionBar?.title = "Daftar Event";
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun showRecyclerList() {
        Log.d("sdsdsd", Gson().toJson(list))
        rvEvent.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = EventsAdapter(list, this)
        rvEvent.adapter = listHeroAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}