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
import com.example.wisata.models.JenisDestinasi
import kotlinx.android.synthetic.main.jenis_destinasi_item.view.*
import org.jetbrains.anko.startActivity

class JenisDestinasiAdapter(private val jenisDestinasiList: List<JenisDestinasi>, val context: Context?) : RecyclerView.Adapter<JenisDestinasiAdapter.JenisDestinasiViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JenisDestinasiViewHolder {
        return JenisDestinasiViewHolder(LayoutInflater.from(context).inflate(R.layout.jenis_destinasi_item, parent, false))
    }

    override fun getItemCount(): Int = jenisDestinasiList.size


    override fun onBindViewHolder(holder: JenisDestinasiViewHolder, position: Int) {
        holder.bind(jenisDestinasiList[position])
    }

    inner class JenisDestinasiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(jenisDestinasi: JenisDestinasi) {

            itemView.tv_jenis_destinasi.text = jenisDestinasi.jenis_destinasi

            Glide.with(itemView.context)
                .load(ServerConfig.JENIS_DESTINASI_PATH+jenisDestinasi.icon)
                .apply(RequestOptions().placeholder(R.drawable.ic_hourglass_empty_black_24dp))
                .into(itemView.image)

            itemView.setOnClickListener {
                context?.startActivity<DestinasiActivity>(DestinasiActivity.EXTRA_JENIS_DESTINASI to jenisDestinasi)
            }

            /*
            itemView.setOnClickListener {
                val jenisdestinasi = Intent(context, DestinasiActivity::class.java)
                jenisdestinasi.putExtra(DestinasiActivity.EXTRA_JENIS_DESTINASI, jenisdestinasi)
                context?.startActivity(jenisdestinasi)
            }
            */
        }
    }

}