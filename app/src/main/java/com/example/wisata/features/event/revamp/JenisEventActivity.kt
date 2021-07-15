package com.example.wisata.features.event.revamp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wisata.R
import com.example.wisata.adapter.JenisEventAdapter
import com.example.wisata.models.JenisEvent
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_jenis_event.*

class JenisEventActivity : AppCompatActivity() {
    private var list: ArrayList<JenisEvent> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jenis_event)
        initToolbar()

        rv_jenis_event.setHasFixedSize(true)

        list.addAll(JenisEventData.listData)
        showRecyclerList()
    }

    private fun initToolbar() {
        supportActionBar?.title = "Jenis Event";
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun showRecyclerList() {
        Log.d("sdsdsd", Gson().toJson(list))
        rv_jenis_event.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = JenisEventAdapter(list, this)
        rv_jenis_event.adapter = listHeroAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}