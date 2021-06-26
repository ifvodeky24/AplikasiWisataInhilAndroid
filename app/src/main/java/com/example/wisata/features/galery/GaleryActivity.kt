package com.example.wisata.features.galery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wisata.R
import com.example.wisata.adapter.EventAdapter
import com.example.wisata.adapter.GalleryAdapter
import com.example.wisata.features.event.EventContract
import com.example.wisata.features.event.EventPresenter
import com.example.wisata.models.Event
import com.example.wisata.models.Gallery
import com.example.wisata.repositories.EventRepositoryImp
import com.example.wisata.repositories.GalleryRepositoryImp
import com.example.wisata.rest.WisataApiService
import com.example.wisata.rest.WisataRest
import com.example.wisata.utils.hide
import com.example.wisata.utils.show
import com.rahmat.app.footballclub.utils.AppSchedulerProvider
import kotlinx.android.synthetic.main.activity_event.*
import kotlinx.android.synthetic.main.activity_galery.*
import kotlinx.android.synthetic.main.activity_jenis_destinasi.*
import kotlinx.android.synthetic.main.activity_jenis_destinasi.mainProgress

class GaleryActivity : AppCompatActivity(), GalleryContract.View  {
    lateinit var mPresenter: GalleryPresenter
    private var galleryLists: MutableList<Gallery> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_galery)
        initToolbar()
        initEnv()
    }

    private fun initToolbar() {
        supportActionBar?.title = "Gallery";
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initEnv(){
        val service = WisataApiService.getClient().create(WisataRest::class.java)
        val request = GalleryRepositoryImp(service)
        val scheduler = AppSchedulerProvider()
        mPresenter = GalleryPresenter(
            this,
            request,
            scheduler
        )
        mPresenter.getGalleryData()
    }
    override fun hideLoading() {
        mainProgress.hide()
        rvGallery.visibility = View.VISIBLE
    }

    override fun showLoading() {
        mainProgress.show()
        rvGallery.visibility = View.INVISIBLE
    }

    override fun displayGallery(gallery: List<Gallery>) {
        galleryLists.clear()
        galleryLists.addAll(gallery)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvGallery.layoutManager =layoutManager
        rvGallery.setHasFixedSize(true)
        rvGallery.adapter = GalleryAdapter(gallery, this);
    }
}
