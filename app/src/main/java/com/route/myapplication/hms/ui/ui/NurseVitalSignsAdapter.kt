package com.route.myapplication.hms.ui.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.myapplication.hms.R

class NurseVitalSignsAdapter(var items :List<NurseVitalSignsDetails>) : RecyclerView.Adapter<NurseVitalSignsAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var date: TextView = itemView.findViewById(R.id.date_tv_nurse)
        var time: TextView = itemView.findViewById(R.id.Time_tv_nurse)
        var weight: TextView = itemView.findViewById(R.id.weight_tv_nurse)
        var bloodPressure: TextView = itemView.findViewById(R.id.bloodPressure_tv_nurse)
        var pulseRate: TextView = itemView.findViewById(R.id.pulseRate_tv_nurse)
        var temperature: TextView = itemView.findViewById(R.id.temprature_tv_nurse)
        var respiratory: TextView = itemView.findViewById(R.id.respiratoryRate_tv_nurse)
        var signature: TextView = itemView.findViewById(R.id.signature_tv_nurse)
        var comments: TextView = itemView.findViewById(R.id.comments_tv_nurse)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_nurse_inpatient_vitalsigns_layout, parent, false)
        return NurseVitalSignsAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = items[position]

        holder.date.setText(item.Date.toString())
        holder.time.setText(item.Time.toString())
        holder.weight.setText(item.Weight.toString())
        holder.bloodPressure.setText(item.BloodPressure.toString())

        holder.pulseRate.setText(item.PulseRate.toString())
        holder.temperature.setText(item.Temperature.toString())
        holder.respiratory.setText(item.RespiratoryRate.toString())
        holder.signature.setText(item.Signature.toString())
        holder.comments.setText(item.Comments.toString())

    }

    override fun getItemCount(): Int {
        return items.size
    }
}