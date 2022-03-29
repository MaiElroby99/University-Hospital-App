package com.route.myapplication.hms.ui.Menufragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.route.myapplication.hms.R
import com.route.myapplication.hms.ui.ui.StaffMemberAdapter
import com.route.myapplication.hms.ui.ui.StaffMemberDetails


class StaffMembersFragment : Fragment() {
    lateinit var addStaffMemberBtn: Button
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: StaffMemberAdapter
    lateinit var items_row: MutableList<StaffMemberDetails>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_staff_members, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = requireView().findViewById(R.id.recyclerView_staff_members)
        items_row = AddingItems()
        adapter = StaffMemberAdapter(items_row)
        recyclerView.adapter = adapter

        addStaffMemberBtn = requireView().findViewById(R.id.addStaffMembers_btn)
        addStaffMemberBtn.setOnClickListener {
            getParentFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, AddStaffMemberFragment())
                .addToBackStack("")
                .commit()
        }
    }

    private fun AddingItems(): MutableList<StaffMemberDetails> {
        val items: MutableList<StaffMemberDetails> = arrayListOf()

        for (i in 0..50) {
            items.add(
                StaffMemberDetails(
                    R.drawable.ic_doctor,
                    "Ziad",
                    "01111111111",
                    "a.bb@yahoo.com",
                    "male",
                    23,
                    "address",
                    "010999999",
                    "A"
                )
            )

        }
        return items
    }
}