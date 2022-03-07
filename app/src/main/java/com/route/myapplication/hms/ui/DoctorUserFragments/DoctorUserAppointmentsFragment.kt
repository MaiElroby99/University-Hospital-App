package com.route.myapplication.hms.ui.DoctorUserFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.myapplication.hms.R
import com.route.myapplication.hms.ui.ui.AppointmentsDetails
import com.route.myapplication.hms.ui.ui.DoctorAppointmentAdapter
import com.route.myapplication.hms.ui.ui.DoctorsAdapter
import com.route.myapplication.hms.ui.ui.DoctorsDetails


class DoctorUserAppointmentsFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter : DoctorAppointmentAdapter
    lateinit var items_row: MutableList<AppointmentsDetails>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_doctor_user_appointments, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView =requireView().findViewById(R.id.DoctorAppointment_recyclerView)
        items_row = AddingItems()
        adapter = DoctorAppointmentAdapter(items_row)
        recyclerView.adapter = adapter

}

    private fun AddingItems() : MutableList<AppointmentsDetails>{
        val items: MutableList<AppointmentsDetails> = arrayListOf()
//        items.add(AppointmentsDetails(1,"Ahmed","Sunday","2/5/2022","3:30"))
        for (i in 0..999) {
            items.add(AppointmentsDetails(i+1,"Ahmed","Sunday","2/5/2022","3:30"))
        }
        return items
    }
    }