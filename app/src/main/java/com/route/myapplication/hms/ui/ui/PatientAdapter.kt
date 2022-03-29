package com.route.myapplication.hms.ui.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.myapplication.hms.R

class PatientAdapter(var items :List<PatientDetails>) : RecyclerView.Adapter<PatientAdapter.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var Image : ImageView = itemView.findViewById(R.id.Image_patient)
        var Name : TextView = itemView.findViewById(R.id.name_patient)
        var NationalID : TextView = itemView.findViewById(R.id.nationalID_patient)
        var Email : TextView = itemView.findViewById(R.id.email_patient)
        var Gender : TextView = itemView.findViewById(R.id.gender_patient)
        var Age : TextView = itemView.findViewById(R.id.age_patient)
        var Address : TextView = itemView.findViewById(R.id.address_patient)
        var Phone : TextView = itemView.findViewById(R.id.phone_patient)
        var BloodType : TextView = itemView.findViewById(R.id.blood_type_patient)


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientAdapter.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_layout_patients,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PatientAdapter.ViewHolder, position: Int) {
        var item = items[position]

        if(item.imageID != null){
            holder.Image.setImageResource((item.imageID!!))
        }
        holder.Name.setText(item.name.toString())
        holder.NationalID.setText(item.nationalID.toString())
        holder.Email.setText(item.email.toString())
        holder.Gender.setText(item.gender.toString())
        if(item.age != null){
            holder.Age.setText(item.age.toString()!!)        }
        holder.Address.setText(item.address.toString())

        holder.Phone.setText(item.phone.toString())
//        holder.Degree.setText(item.degree.toString())
        holder.BloodType.setText(item.blood_type.toString())

    }


    override fun getItemCount(): Int {
        return items.size
    }

}