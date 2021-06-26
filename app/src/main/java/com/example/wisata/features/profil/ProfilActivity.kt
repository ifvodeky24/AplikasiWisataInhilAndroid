package com.example.wisata.features.profil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.wisata.R
import kotlinx.android.synthetic.main.activity_profil.*

class ProfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)
        initToolbar()
        initComponent()
    }

    private fun initComponent() {
        ll_kabupaten_indragiri_hilir.setOnClickListener {
            val intent = Intent(this, TentangKabupatenIndragiriHilirActivity::class.java)
            startActivity(intent)
        }

        ll_program_kerja.setOnClickListener {
            val intent = Intent(this, ProkerActivity::class.java)
            startActivity(intent)
        }

        ll_sejarah_indragiri_hilir.setOnClickListener {
            val intent = Intent(this, SejarahActivity::class.java)
            startActivity(intent)
        }

        ll_struktur_organisasi.setOnClickListener {
            val intent = Intent(this, StrukturOrganisasiActivity::class.java)
            startActivity(intent)
        }


        ll_tentang_kami.setOnClickListener {
            val intent = Intent(this, TentangActivity::class.java)
            startActivity(intent)
        }

        ll_tugas_fungsi.setOnClickListener{
            val intent = Intent(this, TugasFungsiActivity::class.java)
            startActivity(intent)
        }

        ll_visi_misi.setOnClickListener {
            val intent = Intent(this, VisiMisiActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initToolbar() {
        supportActionBar?.title = "Profil"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
