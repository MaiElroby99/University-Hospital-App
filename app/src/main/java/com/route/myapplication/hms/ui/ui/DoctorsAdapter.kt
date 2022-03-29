package com.route.myapplication.hms.ui.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.myapplication.hms.R

class DoctorsAdapter(var items :List<DoctorsDetails>) : RecyclerView.Adapter<DoctorsAdapter.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var Image : ImageView = itemView.findViewById(R.id.Image_doctors)
        var Name : TextView = itemView.findViewById(R.id.name_doctors)
        var NationalID : TextView = itemView.findViewById(R.id.nationalID_doctors)
        var Email : TextView = itemView.findViewById(R.id.email_doctors)
        var Gender : TextView = itemView.findViewById(R.id.gender_doctors)
        var Age : TextView = itemView.findViewById(R.id.age_doctors)
        var Address : TextView = itemView.findViewById(R.id.address_doctors)
        var Phone : TextView = itemView.findViewById(R.id.phone_doctors)
        var Degree : TextView = itemView.findViewById(R.id.degree_doctors)
        var Department : TextView = itemView.findViewById(R.id.department_doctors)
//        var Option1 : ImageView = itemView.findViewById(R.id.option1)
//        var Option2 : ImageView? = itemView.findViewById(R.id.option2)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorsAdapter.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_layout_doctors,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: DoctorsAdapter.ViewHolder, position: Int) {
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
        holder.Degree.setText(item.degree.toString())
        holder.Department.setText(item.department.toString())
//        if(item.option1ID != null){
//            holder.Option1.setImageResource((item.option1ID!!))
//        }
//        if(item.option2ID != null){
//            holder.Option2?.setImageResource((item.option2ID!!))
//        }
    }


    override fun getItemCount(): Int {
        return items.size
    }

}