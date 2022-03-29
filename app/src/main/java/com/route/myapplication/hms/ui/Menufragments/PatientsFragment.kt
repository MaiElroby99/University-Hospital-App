package com.route.myapplication.hms.ui.Menufragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.route.myapplication.hms.R
import com.route.myapplication.hms.ui.ui.PatientAdapter
import com.route.myapplication.hms.ui.ui.PatientDetails


class PatientsFragment : Fragment() {

    lateinit var addPatientBtn : Button
    lateinit var recyclerView: RecyclerView
    lateinit var adapter : PatientAdapter
    lateinit var items_row: MutableList<PatientDetails>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_patients, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView =requireView().findViewById(R.id.recyclerView_patients)
        items_row = AddingItems()
        adapter = PatientAdapter(items_row)
        recyclerView.adapter = adapter

        addPatientBtn = requireView().findViewById(R.id.addPatient_btn)
        addPatientBtn.setOnClickListener {
            getParentFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, AddPatientFragment())
                .addToBackStack("")
                .commit()
        }
    }

    private fun AddingItems() : MutableList<PatientDetails>{
        val items: MutableList<PatientDetails> = arrayListOf()

        for (i in 0..50) {
            items.add(PatientDetails(R.drawable.ic_doctor, "Ziad", "01111111111","a.bb@yahoo.com","male",23,"address","010999999","A"))

        }
        return items
    }

}