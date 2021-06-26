package com.example.wisata.adapter

import android.content.Context
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
import com.example.wisata.features.destinasi.detaildestinasi.DetailDestinasiActivity
import com.example.wisata.models.Destinasi
import com.example.wisata.models.JenisDestinasi
import kotlinx.android.synthetic.main.destinasi_item.view.*
import kotlinx.android.synthetic.main.jenis_destinasi_item.view.*
import org.jetbrains.anko.startActivity

class DestinasiAdapter(private val destinasiList: List<Destinasi>, val context: Context?) : RecyclerView.Adapter<DestinasiAdapter.DestinasiViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DestinasiViewHolder {
        return DestinasiViewHolder(LayoutInflater.from(context).inflate(R.layout.destinasi_item, parent, false))
    }

    override fun getItemCount(): Int = destinasiList.size

    override fun onBindViewHolder(holder: DestinasiViewHolder, position: Int) {
        holder.bind(destinasiList[position])
    }

    inner class DestinasiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(destinasi: Destinasi) {
            /*
            if (jenisDestinasi.intHomeScore == null) {
                itemView.dateScheduleTv.setTextColor(itemView.context.resources.getColor(R.color.upcoming_match))
            }
             */
            itemView.tv_nama.text = destinasi.nama
            itemView.tv_alamat.text = destinasi.alamat
            Glide.with(itemView.context)
                .load(ServerConfig.DESTINASI_PATH+destinasi.photo)
                .apply(RequestOptions().placeholder(R.drawable.ic_hourglass_empty_black_24dp))
                .into(itemView.iv_destinasi)
            itemView.setOnClickListener {
                itemView.context.startActivity<DetailDestinasiActivity>(DetailDestinasiActivity.EXTRA_DESTINASI to destinasi)
            }
        }
    }

}