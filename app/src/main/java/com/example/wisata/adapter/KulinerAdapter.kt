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
import com.example.wisata.features.destinasi.DestinasiActivity
import com.example.wisata.features.kuliner.KulinerActivity
import com.example.wisata.features.kuliner.KulinerDetailActivity
import com.example.wisata.models.Berita
import com.example.wisata.models.Event
import com.example.wisata.models.JenisDestinasi
import com.example.wisata.models.Kuliner
import kotlinx.android.synthetic.main.berita_item.view.*
import kotlinx.android.synthetic.main.event_item.view.*
import kotlinx.android.synthetic.main.jenis_destinasi_item.view.*
import kotlinx.android.synthetic.main.kuliner_item.view.*
import org.jetbrains.anko.startActivity

class KulinerAdapter(private val kulinerList: List<Kuliner>, val context: Context?) : RecyclerView.Adapter<KulinerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.kuliner_item, parent, false))
    }

    override fun getItemCount(): Int = kulinerList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(kulinerList[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(kuliner: Kuliner) {

            itemView.tv_judul_kuliner.text = kuliner.judul
//            itemView.tv_tanggal_kuliner.text = kuliner.createdAt
//            itemView.tv_isi_kuliner.text = kuliner.isi

            Glide.with(itemView.context)
                .load(ServerConfig.KULINER_PATH+kuliner.gambar)
                .apply(RequestOptions().placeholder(R.drawable.ic_hourglass_empty_black_24dp))
                .into(itemView.iv_kuliner)


            itemView.setOnClickListener {
                context?.startActivity<KulinerDetailActivity>(KulinerDetailActivity.EXTRA_KULINER to kuliner)
            }

        }
    }

}