package com.example.wisata.features.main

import android.Manifest
import android.app.Dialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.viewpager.widget.ViewPager
import com.example.wisata.R
import com.example.wisata.adapter.BeritaAdapter
import com.example.wisata.adapter.ImagesAdapter
import com.example.wisata.data.ImagesData
import com.example.wisata.features.berita.BeritaActivity
import com.example.wisata.features.event.EventActivity
import com.example.wisata.features.galery.GaleryActivity
import com.example.wisata.features.jenisdestinasi.JenisDestinasiActivity
import com.example.wisata.features.kontak.KontakActivity
import com.example.wisata.features.kuliner.KulinerActivity
import com.example.wisata.features.petawisata.PetaWisataActivity
import com.example.wisata.features.profil.ProfilActivity
import com.example.wisata.models.Berita
import com.example.wisata.models.Images
import com.example.wisata.repositories.BeritaRepositoryImp
import com.example.wisata.rest.WisataApiService
import com.example.wisata.rest.WisataRest
import com.example.wisata.utils.hide
import com.example.wisata.utils.show
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.rahmat.app.footballclub.utils.AppSchedulerProvider
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_contact_project.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), MainBeritaContract.View {

    lateinit var mPresenter: MainBeritaPresenter
    private var beritaList: MutableList<Berita> = mutableListOf()
    private var list: ArrayList<Images> = arrayListOf()

    private var dotscount: Int = 0
    private var dots: Array<ImageView?>? = null
    private var viewPagerAdapter: BannerViewPagerAdapter? = null
    private var timer: Timer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkPermision()
        initComponent()
        initEnv()
    }

    private fun initEnv() {
        val service = WisataApiService.getClient().create(WisataRest::class.java)
        val request = BeritaRepositoryImp(service)
        val scheduler = AppSchedulerProvider()
        mPresenter = MainBeritaPresenter(this, request, scheduler)
        mPresenter.getBeritaData()
    }

    private fun initComponent() {
        fb_event.setOnClickListener {
            val intent = Intent(this, EventActivity::class.java)
            startActivity(intent)
        }

        fb_destinasi.setOnClickListener {
            val intent = Intent(this, JenisDestinasiActivity::class.java)
            startActivity(intent)
        }

        fb_kuliner.setOnClickListener {
            val intent = Intent(this, KulinerActivity::class.java)
            startActivity(intent)
        }

        fb_profil.setOnClickListener {
            val intent = Intent(this, ProfilActivity::class.java)
            startActivity(intent)
        }

        fb_gallery.setOnClickListener {
            val intent = Intent(this, GaleryActivity::class.java)
            startActivity(intent)
        }

        fb_berita.setOnClickListener {
            val intent = Intent(this, BeritaActivity::class.java)
            startActivity(intent)
        }

        fb_peta_wisata.setOnClickListener {
            val intent = Intent(this, PetaWisataActivity::class.java)
            startActivity(intent)
        }

        fb_kontak.setOnClickListener {
            val intent = Intent(this, KontakActivity::class.java)
            startActivity(intent)
        }

        list.addAll(ImagesData.listData)
        showHorizontalImage()

        tv_lainnya_berita.setOnClickListener {
            val intent = Intent(this, BeritaActivity::class.java)
            startActivity(intent)
        }

        viewPagerAdapter = BannerViewPagerAdapter(this)
        vp_galeri.adapter = viewPagerAdapter

        viewPagerAdapter.let { viewPagerAdapter ->
            if (viewPagerAdapter != null) {
                dotscount = viewPagerAdapter.count
            }
        }

        dots = arrayOfNulls(dotscount)

        val params = LinearLayoutCompat.LayoutParams(
            LinearLayoutCompat.LayoutParams.WRAP_CONTENT,
            LinearLayoutCompat.LayoutParams.WRAP_CONTENT
        )
        params.marginStart = 8
        params.marginEnd = 8
        params.setMargins(8, 0, 8, 0)

        if (dots != null) {
            for (i in dots!!.indices) {
                val img = ImageView(this@MainActivity)
                dots!![i] = img
                dots!![i]?.setImageDrawable(
                    ContextCompat.getDrawable(
                        this@MainActivity,
                        R.drawable.nonactive_dot
                    )
                )
                slider_dots.addView(dots!![i], params)
            }

            dots!![0]?.setImageDrawable(
                ContextCompat.getDrawable(
                    this@MainActivity,
                    R.drawable.active_dot
                )
            )
        }

        vp_galeri.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {

                if (dots != null) {
                    for (i in dots!!.indices) {
                        dots!![i]?.setImageDrawable(
                            ContextCompat.getDrawable(
                                this@MainActivity,
                                R.drawable.nonactive_dot
                            )
                        )
                    }

                    dots!![position]?.setImageDrawable(
                        ContextCompat.getDrawable(
                            this@MainActivity,
                            R.drawable.active_dot
                        )
                    )
                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

        timer = Timer()
        timer?.scheduleAtFixedRate(MyTimerTask(), 2000, 8000)
    }

    private fun showDialogContact() {

        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_contact_project)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(true)

        dialog.bt_close.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun showHorizontalImage() {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerCenter.layoutManager = layoutManager
        layoutManager.reverseLayout = true
        recyclerCenter.adapter = ImagesAdapter(list)
        LinearSnapHelper().attachToRecyclerView(recyclerCenter)
    }

    override fun hideLoading() {
        mainProgress.hide()
        rvBerita.visibility = View.VISIBLE
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

    inner class MyTimerTask : TimerTask() {
        override fun run() {
            CoroutineScope(Dispatchers.Main).launch {
                when (vp_galeri.currentItem) {
                    0 -> vp_galeri.currentItem = 1
                    1 -> vp_galeri.currentItem = 2
                    2 -> vp_galeri.currentItem = 3
                    3 -> vp_galeri.currentItem = 4
                    4 -> vp_galeri.currentItem = 5
                    5 -> vp_galeri.currentItem = 6
                    6 -> vp_galeri.currentItem = 7
                    else -> vp_galeri.currentItem = 0
                }
            }
        }
    }

    private fun checkPermision() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
            != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_PHONE_STATE
            )
            != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            )
            != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
            != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
            != PackageManager.PERMISSION_GRANTED
        ) {
            Toast.makeText(
                this,
                "Mohon izinkan semua permission yang dibutuhkan",
                Toast.LENGTH_SHORT
            ).show()

            Dexter.withContext(this)
                .withPermissions(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ).withListener(object : MultiplePermissionsListener {
                    override fun onPermissionsChecked(report: MultiplePermissionsReport) { /* ... */
                    }

                    override fun onPermissionRationaleShouldBeShown(
                        permissions: List<PermissionRequest>,
                        token: PermissionToken
                    ) { /* ... */
                        checkPermision()
                    }
                }).check()
        }
    }
}
