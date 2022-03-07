package com.route.myapplication.hms.ui.DoctorUserFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.myapplication.hms.R
import com.route.myapplication.hms.ui.ui.DoctorInpatientAdapter
import com.route.myapplication.hms.ui.ui.InpatientDetails
import com.route.myapplication.hms.ui.ui.VitalSignsAdapter
import com.route.myapplication.hms.ui.ui.VitalSignsDetails

class VitalSignsFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter : VitalSignsAdapter
    lateinit var items: MutableList<VitalSignsDetails>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vital_signs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView =requireView().findViewById(R.id.DoctorinpatientVitalSigns_recyclerView)
        items = AddingItems()
        adapter = VitalSignsAdapter(items)
        recyclerView.adapter = adapter
    }

    private fun AddingItems() : MutableList<VitalSignsDetails>{
        val items: MutableList<VitalSignsDetails> = arrayListOf()
        for (i in 0..999) {
            items.add(
                VitalSignsDetails("10/10/2020","10pm",50,28,30,37,60,"amira","comment"))
        }
        return items
    }

}