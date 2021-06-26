package com.example.wisata.features.event

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wisata.R
import com.example.wisata.adapter.EventAdapter
import com.example.wisata.models.Event
import com.example.wisata.repositories.EventRepositoryImp
import com.example.wisata.rest.WisataApiService
import com.example.wisata.rest.WisataRest
import com.example.wisata.utils.hide
import com.example.wisata.utils.show
import com.rahmat.app.footballclub.utils.AppSchedulerProvider
import kotlinx.android.synthetic.main.activity_event.*
import kotlinx.android.synthetic.main.activity_jenis_destinasi.mainProgress

class EventActivity : AppCompatActivity(), EventContract.View {
    lateinit var mPresenter: EventPresenter
    private var eventLists: MutableList<Event> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)
        initToolbar()
        initEnv()
    }

    private fun initToolbar() {
        supportActionBar?.title = "Event";
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initEnv() {
        val service = WisataApiService.getClient().create(WisataRest::class.java)
        val request = EventRepositoryImp(service)
        val scheduler = AppSchedulerProvider()
        mPresenter = EventPresenter(
            this,
            request,
            scheduler
        )
        mPresenter.getEventData()
    }

    override fun hideLoading() {
        mainProgress.hide()
        rvEvent.visibility = View.VISIBLE
    }

    override fun showLoading() {
        mainProgress.show()
        rvEvent.visibility = View.INVISIBLE
    }

    override fun displayEvent(event: List<Event>) {
        eventLists.clear()
        eventLists.addAll(event)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvEvent.layoutManager =layoutManager
        rvEvent.setHasFixedSize(true)
        rvEvent.adapter = EventAdapter(event, this);
    }
}

