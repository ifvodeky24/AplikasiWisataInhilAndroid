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
import com.example.wisata.features.event.revamp.DetailEventsActivity
import com.example.wisata.features.event.revamp.EventsActivity
import com.example.wisata.models.Events

class EventsAdapter (private val eventsList: ArrayList<Events>, val context: Context?) :
    RecyclerView.Adapter<EventsAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.event_item, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val events = eventsList[position]
        Glide.with(holder.itemView.context)
            .load(events.image)
            .into(holder.imgPhoto)
        holder.tvJudul.text = events.name
        holder.tvIsi.text = events.description

        holder.itemView.setOnClickListener {
//            Toast.makeText(context, "heiii ${events.name}", Toast.LENGTH_SHORT).show()
            val intent = Intent(context, DetailEventsActivity::class.java)
            intent.putExtra(DetailEventsActivity.EXTRA_EVENT, events)
            context?.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return eventsList.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvJudul: TextView = itemView.findViewById(R.id.tv_judul_event)
        var tvTanggal: TextView = itemView.findViewById(R.id.tv_tanggal_event)
        var tvIsi: TextView = itemView.findViewById(R.id.tv_isi_event)
        var imgPhoto: ImageView = itemView.findViewById(R.id.iv_event)
    }
}