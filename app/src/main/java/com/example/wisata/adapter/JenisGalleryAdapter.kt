package com.example.wisata.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.wisata.R
import com.example.wisata.features.event.revamp.EventsActivity
import com.example.wisata.features.galery.revamp.GalleriesActivity
import com.example.wisata.models.JenisGallery

class JenisGalleryAdapter(private val jenisGalleryList: List<JenisGallery>, val context: Context?) :
    RecyclerView.Adapter<JenisGalleryAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.jenis_gallery_item, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val jenisGallery = jenisGalleryList[position]
        Glide.with(holder.itemView.context)
            .load(jenisGallery.image)
            .into(holder.imgPhoto)
        holder.tvName.text = jenisGallery.jenisGallery

        holder.itemView.setOnClickListener {
//            Toast.makeText(context, "heiii ${jenisGallery.jenisGallery}", Toast.LENGTH_SHORT).show()
            val intent = Intent(context, GalleriesActivity::class.java)
            intent.putExtra(GalleriesActivity.EXTRA_ID, jenisGallery.id)
            context?.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return jenisGalleryList.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_title)
        var imgPhoto: ImageView = itemView.findViewById(R.id.iv_gallery)
    }
}