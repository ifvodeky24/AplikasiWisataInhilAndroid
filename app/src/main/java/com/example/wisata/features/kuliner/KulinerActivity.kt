package com.example.wisata.features.kuliner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wisata.R
import com.example.wisata.adapter.KulinerAdapter
import com.example.wisata.models.Kuliner
import com.example.wisata.repositories.KulinerRepositoryImp
import com.example.wisata.rest.WisataApiService
import com.example.wisata.rest.WisataRest
import com.example.wisata.utils.hide
import com.example.wisata.utils.show
import com.rahmat.app.footballclub.utils.AppSchedulerProvider
import kotlinx.android.synthetic.main.activity_kuliner.*

class KulinerActivity : AppCompatActivity(), MainKulinerContract.View {
    lateinit var mPresenter: MainKulinerPresenter
    private var eventLists: MutableList<Kuliner> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kuliner)
        initToolbar()
        initEnv()
    }

    private fun initToolbar() {
        supportActionBar?.title = "Kuliner";
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
        val request = KulinerRepositoryImp(service)
        val scheduler = AppSchedulerProvider()
        mPresenter = MainKulinerPresenter(this, request, scheduler)
        mPresenter.getKulinerData()
    }

    override fun hideLoading() {
        mainProgress.hide()
        rvEvent.visibility = View.VISIBLE
    }

    override fun showLoading() {
        mainProgress.show()
        rvEvent.visibility = View.INVISIBLE
    }

    override fun displayKuliner(kuliner: List<Kuliner>) {
        eventLists.clear()
        eventLists.addAll(kuliner)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvEvent.layoutManager =layoutManager
        rvEvent.setHasFixedSize(true)
        rvEvent.adapter = KulinerAdapter(kuliner, this);
    }
}

