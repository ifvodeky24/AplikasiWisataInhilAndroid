package com.example.wisata.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.wisata.R
import com.example.wisata.models.Images

class ImagesAdapter(private val listImages: ArrayList<Images>) : RecyclerView.Adapter<ImagesAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_images, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val hero = listImages[position]
        Glide.with(holder.itemView.context)
            .load(hero.photo)
//            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)
        // holder.tvName.text = hero.name
        // holder.tvDetail.text = hero.detail
    }

    override fun getItemCount(): Int {
        return listImages.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.image)
    }
}