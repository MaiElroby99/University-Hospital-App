package com.route.myapplication.hms.ui.NurseUserFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.myapplication.hms.R
import com.route.myapplication.hms.ui.ui.*

class NurseUserShowVitalSignsFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter : NurseVitalSignsAdapter
    lateinit var items: MutableList<NurseVitalSignsDetails>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vital_signs_nurse, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView =requireView().findViewById(R.id.NurseInpatientVitalSigns_recyclerView)
        items = AddingItems()
        adapter = NurseVitalSignsAdapter(items)
        recyclerView.adapter = adapter
    }

    private fun AddingItems() : MutableList<NurseVitalSignsDetails>{
        val items: MutableList<NurseVitalSignsDetails> = arrayListOf()
        for (i in 0..999) {
            items.add(
                NurseVitalSignsDetails("10/10/2020","10pm",50,28,30,37,60,"amira","comment"))
        }
        return items
    }

}