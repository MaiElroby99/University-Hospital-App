package com.route.myapplication.hms.ui.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.myapplication.hms.R

class NursesAdapter(var items :List<NursesDetails>) : RecyclerView.Adapter<NursesAdapter.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var Image : ImageView = itemView.findViewById(R.id.Image_nurse)
        var Name : TextView = itemView.findViewById(R.id.name_nurse)
        var NationalID : TextView = itemView.findViewById(R.id.nationalID_nurse)
        var Email : TextView = itemView.findViewById(R.id.email_nurse)
        var Gender : TextView = itemView.findViewById(R.id.gender_nurse)
        var Age : TextView = itemView.findViewById(R.id.age_nurse)
        var Address : TextView = itemView.findViewById(R.id.address_nurse)
        var Phone : TextView = itemView.findViewById(R.id.phone_nurse)
        var Department : TextView = itemView.findViewById(R.id.department_nurse)


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NursesAdapter.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_layout_nurses,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: NursesAdapter.ViewHolder, position: Int) {
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
        holder.Department.setText(item.department.toString())

    }


    override fun getItemCount(): Int {
        return items.size
    }

}