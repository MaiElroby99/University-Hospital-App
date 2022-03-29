package com.route.myapplication.hms.ui.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.myapplication.hms.R

class StaffMemberAdapter(var items :List<StaffMemberDetails>) : RecyclerView.Adapter<StaffMemberAdapter.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var Image : ImageView = itemView.findViewById(R.id.Image_staff_member)
        var Name : TextView = itemView.findViewById(R.id.name_staff_member)
        var NationalID : TextView = itemView.findViewById(R.id.nationalID_staff_member)
        var Email : TextView = itemView.findViewById(R.id.email_staff_member)
        var Gender : TextView = itemView.findViewById(R.id.gender_staff_member)
        var Age : TextView = itemView.findViewById(R.id.age_staff_member)
        var Address : TextView = itemView.findViewById(R.id.address_staff_member)
        var Phone : TextView = itemView.findViewById(R.id.phone_staff_member)
        var Department: TextView = itemView.findViewById(R.id.department_staff_member)


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StaffMemberAdapter.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_layout_staff_members,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: StaffMemberAdapter.ViewHolder, position: Int) {
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