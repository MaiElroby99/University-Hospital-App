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


class NurseUserAddVitalSignFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_vital_sign, container, false)
    }

    }