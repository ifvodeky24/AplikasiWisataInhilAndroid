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
import com.example.wisata.models.Event
import com.example.wisata.models.Gallery
import com.example.wisata.models.JenisDestinasi
import kotlinx.android.synthetic.main.event_item.view.*
import kotlinx.android.synthetic.main.gallery_item.view.*
import kotlinx.android.synthetic.main.jenis_destinasi_item.view.*
import org.jetbrains.anko.startActivity

class GalleryAdapter(private val eventList: List<Gallery>, val context: Context?) : RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        return GalleryViewHolder(LayoutInflater.from(context).inflate(R.layout.gallery_item, parent, false))
    }

    override fun getItemCount(): Int = eventList.size

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.bind(eventList[position])
    }

    inner class GalleryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(event: Gallery) {

            itemView.date.text = event.createdAt
            itemView.title.text = event.judul

            Glide.with(itemView.context)
                .load(ServerConfig.GALLERY_PATH+event.gambar)
                .apply(RequestOptions().placeholder(R.drawable.ic_hourglass_empty_black_24dp))
                .into(itemView.image_gallery)
            /*
            itemView.setOnClickListener {
                context?.startActivity<DestinasiActivity>(DestinasiActivity.EXTRA_JENIS_DESTINASI to event)
            }
             */

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