package com.example.wisata.features.berita

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wisata.R
import com.example.wisata.adapter.BeritaAdapter
import com.example.wisata.features.main.MainBeritaContract
import com.example.wisata.features.main.MainBeritaPresenter
import com.example.wisata.models.Berita
import com.example.wisata.repositories.BeritaRepositoryImp
import com.example.wisata.rest.WisataApiService
import com.example.wisata.rest.WisataRest
import com.example.wisata.utils.hide
import com.example.wisata.utils.show
import com.rahmat.app.footballclub.utils.AppSchedulerProvider
import kotlinx.android.synthetic.main.activity_berita.*
import kotlinx.android.synthetic.main.activity_berita.mainProgress
import kotlinx.android.synthetic.main.activity_berita.rvBerita
import kotlinx.android.synthetic.main.activity_main.*

class BeritaActivity : AppCompatActivity(), MainBeritaContract.View  {
    lateinit var mPresenter: MainBeritaPresenter
    private var beritaList: MutableList<Berita> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_berita)
        initToolbar()
        initEnv()
    }

    private fun initEnv() {
        val service = WisataApiService.getClient().create(WisataRest::class.java)
        val request = BeritaRepositoryImp(service)
        val scheduler = AppSchedulerProvider()
        mPresenter = MainBeritaPresenter(this, request, scheduler)
        mPresenter.getBeritaData()
    }

    private fun initToolbar() {
        supportActionBar?.title = "Berita";
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun hideLoading() {
        mainProgress.hide()
        rvBerita.visibility =  View.VISIBLE
    }

    override fun showLoading() {
        mainProgress.show()
        rvBerita.visibility = View.INVISIBLE
    }

    override fun displayBerita(berita: List<Berita>) {
        beritaList.clear()
        beritaList.addAll(berita)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvBerita.layoutManager = layoutManager
        rvBerita.setHasFixedSize(true)
        rvBerita.adapter = BeritaAdapter(berita, this)
    }
}
