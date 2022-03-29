package com.route.myapplication.hms.ui.DoctorUserFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.myapplication.hms.R
import com.route.myapplication.hms.ui.ui.OutPatientAdapter
import com.route.myapplication.hms.ui.ui.OutPatientDetails


class DoctorUserOutpatientFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter : OutPatientAdapter
    lateinit var items: MutableList<OutPatientDetails>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_doctor_user_outpatient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView =requireView().findViewById(R.id.Doctoroutpatient_recyclerView)
        items = AddingItems()
        adapter = OutPatientAdapter(items)
        recyclerView.adapter = adapter

        adapter.onAppointmentImgClickListener = object : OutPatientAdapter.OnImageClickListener{
            override fun onImageClick(pos: Int, item: OutPatientDetails) {
                pushFragment(MakeAppointmentFragment())
            }
        }

        adapter.onLabImgClickListener = object : OutPatientAdapter.OnImageClickListener{
            override fun onImageClick(pos: Int, item: OutPatientDetails) {
                pushFragment(MakeLab_ScanFragment())
            }
        }

        adapter.onReportImgClickListener = object : OutPatientAdapter.OnImageClickListener{
            override fun onImageClick(pos: Int, item: OutPatientDetails) {
                pushFragment(PatientReportFragment())
            }
        }

        adapter.onPrescriptionImgClickListener = object : OutPatientAdapter.OnImageClickListener{
            override fun onImageClick(pos: Int, item: OutPatientDetails) {
                pushFragment(PrescriptionFragment())
            }
        }
    }

    private fun AddingItems() : MutableList<OutPatientDetails>{
        val items: MutableList<OutPatientDetails> = arrayListOf()
        for (i in 0..999) {
            items.add(
                OutPatientDetails("Ahmed Ali ",
                "ID: 001122334455",
                "Gender: Male",
                "Phone: 01091983199",
                R.drawable.ic_calender,
                R.drawable.ic_test,
                R.drawable.ic_file,
                R.drawable.ic_medicien))
        }
        return items
    }

    private fun pushFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack("back")
            .commit()
    }


}