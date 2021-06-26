package com.example.wisata.features.destinasi.detaildestinasi

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.wisata.R
import com.example.wisata.config.ServerConfig
import com.example.wisata.features.destinasi.DestinasiActivity
import com.example.wisata.models.Destinasi
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import kotlinx.android.synthetic.main.activity_detail_destinasi.*
import kotlinx.android.synthetic.main.destinasi_item.*
import org.jetbrains.anko.find

class DetailDestinasiActivity : AppCompatActivity() {
    lateinit var destinasi: Destinasi
    lateinit var id: String
    lateinit var nama: String
    lateinit var deskripsi: String
    lateinit var jenis_id: String
    lateinit var alamat: String
    lateinit var no_hp: String
    lateinit var website: String
    lateinit var ig: String
    lateinit var fb: String
    lateinit var yt: String
    lateinit var latitude: String
    lateinit var longitude: String
    lateinit var photo: String
    lateinit var jam_buka: String
    private var latitude_know: Double? = null
    private var longitude_know: Double? = null
    private var locationManager: LocationManager?= null
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var locationRequest: LocationRequest
    private lateinit var locationCallback: LocationCallback

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_destinasi)
        initIntent()
        initToolbar()
        initUI()
        getLocation()
    }

    private fun getLocation() {

        val locationManager = getSystemService(LOCATION_SERVICE) as LocationManager?

        val locationListener = object : LocationListener {
            override fun onLocationChanged(location: Location?) {
                latitude_know = location!!.latitude
                longitude_know = location!!.longitude
                Log.e("lat_now_tes", latitude_know.toString())
                Log.e("lng_now_tes", longitude_know.toString())
                Log.e("lat_tes", latitude)
                Log.e("lng_tes", longitude)
                fab_maps_destinasi.setOnClickListener {
                    val mapIntent = Uri.parse(
                        "http://maps.google.com/maps?saddr=$latitude_know,$longitude_know&daddr=$latitude,$longitude"
                    ).let { location ->
                        Intent(Intent.ACTION_VIEW, location);
                    }
                    startActivity(mapIntent)
                }
                Log.i("test", "Latitute: $latitude_know ; Longitute: $longitude_know")

            }

            override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {

            }

            override fun onProviderEnabled(provider: String?) {
            }

            override fun onProviderDisabled(provider: String?) {
            }

        }

        try {
            locationManager!!.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0L, 0f, locationListener)
        } catch (ex:SecurityException) {
            Toast.makeText(applicationContext, "Lokasi tidak ditemukan!", Toast.LENGTH_SHORT).show()
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                PERMISSION_REQUEST_ACCESS_FINE_LOCATION
            )
            return
        }
        locationManager!!.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0L, 0f, locationListener)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_ACCESS_FINE_LOCATION) {
            when (grantResults[0]){
                PackageManager.PERMISSION_GRANTED -> getLocation()
                PackageManager.PERMISSION_DENIED -> "Denied" //Tell to user the need of grant permission
            }
        }
    }

    private fun initUI() {
        // create persistent LocationManager reference
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager?
        tv_name_destinasi.text = nama
        tv_desc_destinasi.text = deskripsi
        tv_address_destinasi.text = alamat
        tv_telp_destinasi.text = no_hp
        tv_jam_buka_destinasi.text = jam_buka
        tv_web_destinasi.text = website
        tv_yt_destinasi.text = yt
        tv_fb_destinasi.text = fb
        tv_ig_destinasi.text = ig
        Glide.with(this)
            .load(ServerConfig.DESTINASI_PATH+photo)
            .apply(RequestOptions().placeholder(R.drawable.ic_hourglass_empty_black_24dp))
            .into(iv_image_destinasi)
    }

    private fun initToolbar() {
        val toolbar = find(R.id.toolbar) as Toolbar?
        setSupportActionBar(toolbar)
        supportActionBar?.setTitle(null)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initIntent() {
        destinasi = intent.getParcelableExtra(EXTRA_DESTINASI)
        id = destinasi.id.toString()
        nama = destinasi.nama.toString()
        deskripsi = destinasi.deskripsi.toString()
        jenis_id = destinasi.jenis_id.toString()
        alamat = destinasi.alamat.toString()
        jam_buka = destinasi.jam_buka.toString()
        no_hp = destinasi.no_hp.toString()
        website = destinasi.website.toString()
        ig = destinasi.ig.toString()
        fb = destinasi.fb.toString()
        yt = destinasi.yt.toString()
        photo = destinasi.photo.toString()
        latitude = destinasi.lat.toString()
        longitude = destinasi.lng.toString()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val EXTRA_DESTINASI = "destinasi"
        private const val PERMISSION_REQUEST_ACCESS_FINE_LOCATION = 100
    }

}
