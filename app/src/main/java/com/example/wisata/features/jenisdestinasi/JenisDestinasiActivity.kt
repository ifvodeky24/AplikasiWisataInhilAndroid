package com.example.wisata.features.jenisdestinasi

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wisata.R
import com.example.wisata.adapter.JenisDestinasiAdapter
import com.example.wisata.models.JenisDestinasi
import com.example.wisata.repositories.JenisDestinasiRepositoryImp
import com.example.wisata.rest.WisataApiService
import com.example.wisata.rest.WisataRest
import com.example.wisata.utils.Tools
import com.example.wisata.utils.hide
import com.example.wisata.utils.show
import com.example.wisata.widget.SpacingItemDecoration
import com.rahmat.app.footballclub.utils.AppSchedulerProvider
import kotlinx.android.synthetic.main.activity_jenis_destinasi.*

class JenisDestinasiActivity : AppCompatActivity(), JenisDestinasiContract.View {
    lateinit var mPresenter: JenisDestinasiPresenter
    private var jenisDestinasiLists: MutableList<JenisDestinasi> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jenis_destinasi)
        initToolbar()
        initEnv()
    }

    private fun initToolbar() {
        supportActionBar?.title = "Jenis Destinasi";
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initEnv() {
        val service = WisataApiService.getClient().create(WisataRest::class.java)
        val request = JenisDestinasiRepositoryImp(service)
        val scheduler = AppSchedulerProvider()
        mPresenter = JenisDestinasiPresenter(this, request, scheduler)
        mPresenter.getJenisDestinasiData()
    }

    override fun hideLoading() {
        mainProgress.hide()
        rvFootballLast.visibility = View.VISIBLE
    }

    override fun showLoading() {
        mainProgress.show()
        rvFootballLast.visibility = View.INVISIBLE
    }

    override fun displayJenisDestinasi(jenisDestinasiList: List<JenisDestinasi>) {
        jenisDestinasiLists.clear()
        jenisDestinasiLists.addAll(jenisDestinasiList)
        val layoutManager = GridLayoutManager(this, 2)
        rvFootballLast.layoutManager = layoutManager
        rvFootballLast.addItemDecoration(SpacingItemDecoration(2, Tools.dpToPx(this, 6), true))
        rvFootballLast.setHasFixedSize(true)
        rvFootballLast.adapter = JenisDestinasiAdapter(jenisDestinasiList, this);
    }
}
