package com.example.wisata.features.petawisata

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.wisata.R
import com.example.wisata.features.destinasi.DestinasiMapContract
import com.example.wisata.features.destinasi.DestinasiMapPresenter
import com.example.wisata.features.destinasi.detaildestinasi.DetailDestinasiActivity
import com.example.wisata.models.Destinasi
import com.example.wisata.repositories.DestinasiMapRepositoryImp
import com.example.wisata.rest.WisataApiService
import com.example.wisata.rest.WisataRest
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.rahmat.app.footballclub.utils.AppSchedulerProvider
import org.jetbrains.anko.startActivity

class PetaWisataActivity : AppCompatActivity(), OnMapReadyCallback, DestinasiMapContract.View {

    private val markerOptions = MarkerOptions()
    private lateinit var cameraPosition: CameraPosition
    private var mMap: GoogleMap? = null
    lateinit var mPresenter: DestinasiMapPresenter
    private var destinasiLists: MutableList<Destinasi> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peta_wisata)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        initEnv()
        initToolbar()
        mapFragment.getMapAsync(this)
    }

    private fun initToolbar() {
        supportActionBar?.title = "Peta Wisata";
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
        val request = DestinasiMapRepositoryImp(service)
        val scheduler = AppSchedulerProvider()
        mPresenter = DestinasiMapPresenter(this, request, scheduler)
        mPresenter.getDestinasiMapData()
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        mMap?.isMyLocationEnabled = true

        // Add a marker in Sydney and move the camera
        val pekanbaru = LatLng(-6.200000, 106.816666)
        cameraPosition = CameraPosition.Builder().target(pekanbaru).zoom(2f).build()
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
        getMarker()
    }

    private fun getMarker() {
        mPresenter.getDestinasiMapData()
    }

    override fun displayDestinasi(destinasi: List<Destinasi>) {
        print("kucing $destinasi")
        destinasiLists.clear()
        destinasiLists.addAll(destinasi)
        for (dataLokasi in destinasiLists) {
            val title: String = dataLokasi.nama.toString()
            val lat: Double = dataLokasi.lat!!.toDouble()
            val lng: Double = dataLokasi.lng!!.toDouble()
            val latLng = LatLng(lat, lng)
            addMarker(dataLokasi, latLng, title)
        }
    }

    private fun addMarker(dataLokasi: Destinasi, latLng: LatLng, title: String) {
        markerOptions.title(title)
        markerOptions.position(latLng)
        mMap?.addMarker(markerOptions)

        mMap?.setOnInfoWindowClickListener { marker ->
//            Toast.makeText(
//                    applicationContext,
//                    "Click" + marker.title,
//                    Toast.LENGTH_SHORT
//            ).show()
            startActivity<DetailDestinasiActivity>(DetailDestinasiActivity.EXTRA_DESTINASI to dataLokasi)
        }
    }
}
