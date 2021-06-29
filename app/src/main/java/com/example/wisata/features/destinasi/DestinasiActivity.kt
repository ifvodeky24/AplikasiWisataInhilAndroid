package com.example.wisata.features.destinasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wisata.R
import com.example.wisata.adapter.DestinasiAdapter
import com.example.wisata.adapter.JenisDestinasiAdapter
import com.example.wisata.features.jenisdestinasi.JenisDestinasiPresenter
import com.example.wisata.models.Destinasi
import com.example.wisata.models.JenisDestinasi
import com.example.wisata.repositories.DestinasiRepositoryImp
import com.example.wisata.repositories.JenisDestinasiRepositoryImp
import com.example.wisata.rest.WisataApiService
import com.example.wisata.rest.WisataRest
import com.example.wisata.utils.Tools
import com.example.wisata.utils.hide
import com.example.wisata.utils.show
import com.example.wisata.widget.SpacingItemDecoration
import com.rahmat.app.footballclub.utils.AppSchedulerProvider
import kotlinx.android.synthetic.main.activity_destinasi.*
import kotlinx.android.synthetic.main.activity_jenis_destinasi.*
import kotlinx.android.synthetic.main.activity_jenis_destinasi.mainProgress

class DestinasiActivity : AppCompatActivity(), DestinasiContract.View {
    lateinit var mPresenter: DestinasiPresenter
    lateinit var jenis_destinasi: JenisDestinasi
    private var destinasiLists: MutableList<Destinasi> = mutableListOf()
    lateinit var id: String

    companion object {
        const val EXTRA_JENIS_DESTINASI = "extra_jenis_destinasi"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destinasi)
        initToolbar()
        initIntent()
        initEnv()
    }

    private fun initToolbar() {
        supportActionBar?.title = "Destinasi";
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initIntent() {
        jenis_destinasi = intent.getParcelableExtra(EXTRA_JENIS_DESTINASI)
        id = jenis_destinasi.id.toString()
    }

    private fun initEnv() {
        val service = WisataApiService.getClient().create(WisataRest::class.java)
        val request = DestinasiRepositoryImp(service)
        val scheduler = AppSchedulerProvider()
        mPresenter = DestinasiPresenter(this, request, scheduler)
        mPresenter.getDestinasiData(id.toInt())
    }

    override fun hideLoading() {
        mainProgress.hide()
        rvDestinasi.visibility = View.VISIBLE
    }

    override fun showLoading() {
        mainProgress.show()
        rvDestinasi.visibility = View.INVISIBLE
    }

    override fun displayDestinasi(destinasi: List<Destinasi>) {
        if (destinasi.isNotEmpty()){
            rvDestinasi.visibility = View.VISIBLE
            ll_empty_list.visibility = View.GONE
            destinasiLists.clear()
            destinasiLists.addAll(destinasi)
            val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            rvDestinasi.layoutManager =layoutManager
            rvDestinasi.setHasFixedSize(true)
            rvDestinasi.adapter = DestinasiAdapter(destinasiLists, this)
        } else {
            rvDestinasi.visibility = View.GONE
            ll_empty_list.visibility = View.VISIBLE
        }
    }
}
