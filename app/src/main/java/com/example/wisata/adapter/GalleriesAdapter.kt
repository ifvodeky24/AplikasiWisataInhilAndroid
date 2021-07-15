package com.example.wisata.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wisata.R
import com.example.wisata.models.Galleries

class GalleriesAdapter (private val galleriesList: ArrayList<Galleries>, val context: Context?) :
    RecyclerView.Adapter<GalleriesAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.gallery_item, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val galleries = galleriesList[position]
        Glide.with(holder.itemView.context)
            .load(galleries.image)
            .into(holder.imgPhoto)

        holder.itemView.setOnClickListener {
//            Toast.makeText(context, "heiii ${events.name}", Toast.LENGTH_SHORT).show()
//            val intent = Intent(context, DetailEventsActivity::class.java)
//            intent.putExtra(DetailEventsActivity.EXTRA_EVENT, events)
//            context?.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return galleriesList.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView.findViewById(R.id.title)
        var imgPhoto: ImageView = itemView.findViewById(R.id.image_gallery)
    }
}