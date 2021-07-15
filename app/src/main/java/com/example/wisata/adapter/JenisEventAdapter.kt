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
import com.example.wisata.R
import com.example.wisata.features.event.revamp.EventsActivity
import com.example.wisata.features.event.revamp.EventsActivity.Companion.EXTRA_ID
import com.example.wisata.models.JenisEvent

class JenisEventAdapter(val jenisEventList: ArrayList<JenisEvent>, val context: Context?) :
    RecyclerView.Adapter<JenisEventAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.jenis_event_item, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val jenisEvent = jenisEventList[position]
        Glide.with(holder.itemView.context)
            .load(jenisEvent.image)
            .into(holder.imgPhoto)
        holder.tvName.text = jenisEvent.jenisEvent

        holder.itemView.setOnClickListener {
            Toast.makeText(context, "heiii ${jenisEvent.jenisEvent}", Toast.LENGTH_SHORT).show()
            val intent = Intent(context, EventsActivity::class.java)
            intent.putExtra(EXTRA_ID, jenisEvent.id)
            context?.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return jenisEventList.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_title)
        var imgPhoto: ImageView = itemView.findViewById(R.id.iv_event)
    }
}