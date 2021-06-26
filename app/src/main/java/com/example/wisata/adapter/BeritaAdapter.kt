package com.example.wisata.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.wisata.R
import com.example.wisata.config.ServerConfig
import com.example.wisata.features.berita.BeritaDetailActivity
import com.example.wisata.features.destinasi.DestinasiActivity
import com.example.wisata.models.Berita
import com.example.wisata.models.Event
import com.example.wisata.models.JenisDestinasi
import kotlinx.android.synthetic.main.berita_item.view.*
import kotlinx.android.synthetic.main.event_item.view.*
import kotlinx.android.synthetic.main.jenis_destinasi_item.view.*
import org.jetbrains.anko.startActivity

class BeritaAdapter(private val beritaList: List<Berita>, val context: Context?) : RecyclerView.Adapter<BeritaAdapter.BeritaViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeritaViewHolder {
        return BeritaViewHolder(LayoutInflater.from(context).inflate(R.layout.berita_item, parent, false))
    }

    override fun getItemCount(): Int = beritaList.size


    override fun onBindViewHolder(holder: BeritaViewHolder, position: Int) {
        holder.bind(beritaList[position])
    }

    inner class BeritaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(berita: Berita) {

            itemView.tv_judul_berita.text = berita.judul
            itemView.tv_tanggal_berita.text = berita.createdAt
            itemView.tv_isi_berita.text = berita.isi

            Glide.with(itemView.context)
                .load(ServerConfig.BERITA_PATH+berita.gambar)
                .apply(RequestOptions().placeholder(R.drawable.ic_hourglass_empty_black_24dp))
                .into(itemView.iv_berita)

            itemView.setOnClickListener {
                context?.startActivity<BeritaDetailActivity>(BeritaDetailActivity.EXTRA_BERITA to berita)
            }

        }
    }

}