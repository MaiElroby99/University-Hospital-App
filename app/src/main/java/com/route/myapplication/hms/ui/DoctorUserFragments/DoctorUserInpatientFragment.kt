package com.route.myapplication.hms.ui.DoctorUserFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.myapplication.hms.R
import com.route.myapplication.hms.ui.ui.*


class DoctorUserInpatientFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter : DoctorInpatientAdapter
    lateinit var items_row: MutableList<InpatientDetails>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_doctor_user_inpatient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView =requireView().findViewById(R.id.Doctorinpatient_recyclerView)
        items_row = AddingItems()
        adapter = DoctorInpatientAdapter(items_row)
        recyclerView.adapter = adapter

        adapter.onVitalSignsImgClickListener = object : DoctorInpatientAdapter.OnImageClickListener{
            override fun onImageClick(pos: Int, item: InpatientDetails) {
                pushFragment(VitalSignsFragment())
            }
        }

        adapter.onLabImgClickListener = object : DoctorInpatientAdapter.OnImageClickListener{
            override fun onImageClick(pos: Int, item: InpatientDetails) {
                pushFragment(MakeLab_ScanFragment())
            }
        }

        adapter.onReportImgClickListener = object : DoctorInpatientAdapter.OnImageClickListener{
            override fun onImageClick(pos: Int, item: InpatientDetails) {
                pushFragment(PatientReportFragment())
            }
        }

        adapter.onPrescriptionImgClickListener = object : DoctorInpatientAdapter.OnImageClickListener{
            override fun onImageClick(pos: Int, item: InpatientDetails) {
                pushFragment(PrescriptionFragment())
            }
        }

    }

    private fun AddingItems() : MutableList<InpatientDetails>{
        val items: MutableList<InpatientDetails> = arrayListOf()
        for (i in 0..999) {
            items.add(
                InpatientDetails("Ahmed Ali ",
                    "ID: 001122334455",
                    "Gender: Male",
                    "Phone: 01091983199",
                    R.drawable.ic_vitalsigns,
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