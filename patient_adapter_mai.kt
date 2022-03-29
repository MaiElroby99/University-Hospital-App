package com.route.myapplication.hms.ui.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.myapplication.hms.R

class PatientAdapter(var items :List<PatientDetails>) : RecyclerView.Adapter<PatientAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var Name : TextView = itemView.findViewById(R.id.patient_name_tv)
        var patientID : TextView = itemView.findViewById(R.id.patient_detailsID_tv)
        var patientGender : TextView = itemView.findViewById(R.id.patient_detailsGender_tv)
        var patientPhone : TextView = itemView.findViewById(R.id.patient_detailsPhone_tv)
        var Appointment : ImageView = itemView.findViewById(R.id.makeAppointment)
        var Lab : ImageView = itemView.findViewById(R.id.test)
        var Report : ImageView = itemView.findViewById(R.id.report)
        var prescription : ImageView = itemView.findViewById(R.id.medication)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_outpatient_layout,parent,false)
        return PatientAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = items[position]

        holder.Name.setText(item.Name.toString())
        holder.patientID.setText(item.ID.toString())
        holder.patientGender.setText(item.Gender.toString())
        holder.patientPhone.setText(item.Phone.toString())

        holder.Appointment.setImageResource((item.CalenderImageId!!))
        holder.Lab.setImageResource((item.LabImageId!!))
        holder.Report.setImageResource((item.ReportImageId!!))
        holder.prescription.setImageResource((item.MedicienImageId!!))

        onAppointmentImgClickListener.let {
            holder.Appointment.setOnClickListener {
                onAppointmentImgClickListener?.onImageClick(position,item)
            }
        }

        onLabImgClickListener.let {
            holder.Lab.setOnClickListener {
                onLabImgClickListener?.onImageClick(position,item)
            }
        }

        onReportImgClickListener.let {
            holder.Report.setOnClickListener {
                onReportImgClickListener?.onImageClick(position,item)
            }
        }

        onPrescriptionImgClickListener.let {
            holder.prescription.setOnClickListener {
                onPrescriptionImgClickListener?.onImageClick(position,item)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    var onAppointmentImgClickListener : OnImageClickListener?=null
    var onLabImgClickListener : OnImageClickListener?=null
    var onReportImgClickListener : OnImageClickListener?=null
    var onPrescriptionImgClickListener : OnImageClickListener?=null

    interface OnImageClickListener{
        fun onImageClick(pos:Int,item:PatientDetails)
    }

}