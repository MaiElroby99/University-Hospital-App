package com.route.myapplication.hms.ui.Menufragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.route.myapplication.hms.R
import com.route.myapplication.hms.ui.ui.NursesAdapter
import com.route.myapplication.hms.ui.ui.NursesDetails


class NursesFragment : Fragment() {
    lateinit var addNurseBtn : Button
    lateinit var recyclerView: RecyclerView
    lateinit var adapter : NursesAdapter
    lateinit var items_row: MutableList<NursesDetails>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nurses, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView =requireView().findViewById(R.id.recyclerView_nurses)
        items_row = AddingItems()
        adapter = NursesAdapter(items_row)
        recyclerView.adapter = adapter

        addNurseBtn = requireView().findViewById(R.id.addNurse_btn)
        addNurseBtn.setOnClickListener {
            getParentFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, AddNurseFragment())
                .addToBackStack("")
                .commit()
        }
    }

    private fun AddingItems() : MutableList<NursesDetails>{
        val items: MutableList<NursesDetails> = arrayListOf()

        for (i in 0..50) {
            items.add(NursesDetails(R.drawable.ic_doctor, "Ali", "01111111111","a.bb@yahoo.com","male",23,"address","010999999","dept"))

        }
        return items
    }


}