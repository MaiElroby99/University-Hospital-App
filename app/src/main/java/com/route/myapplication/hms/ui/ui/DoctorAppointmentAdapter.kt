package com.route.myapplication.hms.ui.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.myapplication.hms.R

class DoctorAppointmentAdapter (var items :List<AppointmentsDetails>):RecyclerView.Adapter<DoctorAppointmentAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var id:TextView = itemView.findViewById(R.id.id_text_view)
        var name:TextView = itemView.findViewById(R.id.name_text_view)
        var day:TextView = itemView.findViewById(R.id.day_text_view)
        var date:TextView = itemView.findViewById(R.id.date_text_view)
        var time:TextView = itemView.findViewById(R.id.time_text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_appointment_layout,parent,false)
        return DoctorAppointmentAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = items[position]
        holder.name.setText(item.name.toString())
        holder.day.setText(item.day.toString())
        holder.date.setText(item.date.toString())
        holder.time.setText(item.time.toString())

    }

    override fun getItemCount(): Int {
        return items.size
    }


}