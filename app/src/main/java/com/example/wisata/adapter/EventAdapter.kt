package com.example.wisata.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.wisata.R
import com.example.wisata.config.ServerConfig
import com.example.wisata.features.event.EventDetailActivity
import com.example.wisata.models.Event
import kotlinx.android.synthetic.main.event_item.view.*
import org.jetbrains.anko.startActivity

class EventAdapter(private val eventList: List<Event>, val context: Context?) :
    RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        return EventViewHolder(
            LayoutInflater.from(context).inflate(R.layout.event_item, parent, false)
        )
    }

    override fun getItemCount(): Int = eventList.size


    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(eventList[position])
    }

    inner class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(event: Event) {

            itemView.tv_judul_event.text = event.judul
            itemView.tv_tanggal_event.text = event.createdAt
            itemView.tv_isi_event.text = event.isi

            Glide.with(itemView.context)
                .load(ServerConfig.EVENT_PATH + event.gambar)
                .apply(RequestOptions().placeholder(R.drawable.ic_hourglass_empty_black_24dp))
                .into(itemView.iv_event)

            itemView.setOnClickListener {
                context?.startActivity<EventDetailActivity>(EventDetailActivity.EXTRA_EVENT to event)
            }
        }
    }
}