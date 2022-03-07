package com.route.myapplication.hms.ui.DoctorUserFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.route.myapplication.hms.R

class PrescriptionFragment : Fragment() {
    val medicineTypeArray =
        arrayOf("Liquid", "Capsules", "Drops", "Injections", "Rectal Suppositories")
    val DurationSpinnerArray = arrayOf("Days", "Month", "Years")

    lateinit var AddPrescribtionBtn: Button
    lateinit var AddPrescribtionLinearLayout: LinearLayout

    lateinit var ConfirmaddPrescribtionBtn: Button
    lateinit var LayoutList: LinearLayout


    lateinit var MedicineNameEditText: EditText
    lateinit var MedicineSterngthEditText: EditText
    lateinit var InstructionsEditText: EditText

    lateinit var MedicinetypeEditText: Spinner
    lateinit var DurationEditText: EditText

    lateinit var DurationSpinner: Spinner
    lateinit var RepetitionEditText: EditText

    lateinit var RepetitionSpinner: Spinner
    lateinit var DoseEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_prescription, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        AddPrescribtionBtn = requireView().findViewById(R.id.addPrescribtionBtn)
        AddPrescribtionLinearLayout = requireView().findViewById(R.id.addPrescribtionLinearLayout)

        ConfirmaddPrescribtionBtn = requireView().findViewById(R.id.confirmaddPrescribtionBtn)
        LayoutList = requireView().findViewById(R.id.layoutList)

        MedicineNameEditText = requireView().findViewById(R.id.medicineNameEditText)
        MedicineSterngthEditText = requireView().findViewById(R.id.medicineSterngthEditText)
        InstructionsEditText = requireView().findViewById(R.id.instructionsEditText)

        MedicinetypeEditText = requireView().findViewById(R.id.medicinetypeEditText)
        DurationEditText = requireView().findViewById(R.id.durationEditText)

        DurationSpinner = requireView().findViewById(R.id.durationSpinner)
        RepetitionEditText = requireView().findViewById(R.id.repetitionEditText)

        RepetitionSpinner = requireView().findViewById(R.id.repetitionSpinner)
        DoseEditText = requireView().findViewById(R.id.doseEditText)



        AddPrescribtionBtn.setOnClickListener {
            AddPrescribtionLinearLayout.isVisible = true
            MedicineNameEditText.setText("")
            MedicineSterngthEditText.setText("")
            InstructionsEditText.setText("")
//            val MedicinetypearrayAdapter = ArrayAdapter(requireContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, medicineTypeArray)
//            MedicinetypeEditText.adapter = MedicinetypearrayAdapter
            DurationEditText.setText("")
            DurationEditText.setText("")
//            val DurationSpinnerarrayAdapter = ArrayAdapter(requireContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, DurationSpinnerArray)
//            DurationSpinner.adapter = DurationSpinnerarrayAdapter
            RepetitionEditText.setText("")
//           val RepetitionSpinnerarrayAdapter = ArrayAdapter(requireContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, DurationSpinnerArray)
//            RepetitionSpinner.adapter = RepetitionSpinnerarrayAdapter
            DoseEditText.setText("")

        }

        ConfirmaddPrescribtionBtn.setOnClickListener {
            AddPrescribtionLinearLayout.isInvisible = true
            addView(
                MedicineNameEditText.text.toString(),
                MedicineSterngthEditText.text.toString(),
                InstructionsEditText.text.toString(),
                MedicinetypeEditText.selectedItemId.toInt(),
                DurationEditText.text.toString(),
                DurationSpinner.selectedItemId.toInt(),
                RepetitionEditText.text.toString(),
                RepetitionSpinner.selectedItemId.toInt(),
                DoseEditText.text.toString()
            )
        }

    }

    private fun addView(
        medicineName: String,
        medicineSterngth: String,
        instructions: String,
        medicinetype: Int,
        duration: String,
        durationSpinner: Int,
        repetition: String,
        repetitionSpinner: Int,
        dose: String
    ) {
        val AddPrescriptionView: View =
            layoutInflater.inflate(R.layout.add_new_prescription, null, false)

        val AddedmedicineNameEditText: EditText =
            AddPrescriptionView.findViewById(R.id.addedmedicineNameEditText)
        AddedmedicineNameEditText.setText(medicineName)
        AddedmedicineNameEditText.isEnabled = false

        val AddedmedicineSterngthEditText: EditText =
            AddPrescriptionView.findViewById(R.id.addedmedicineSterngthEditText)
        AddedmedicineSterngthEditText.setText(medicineSterngth)
        AddedmedicineSterngthEditText.isEnabled = false

        val AddedinstructionsEditText: EditText =
            AddPrescriptionView.findViewById(R.id.addedinstructionsEditText)
        AddedinstructionsEditText.setText(instructions)
        AddedinstructionsEditText.isEnabled = false

        val AddedmedicinetypeEditText: Spinner =
            AddPrescriptionView.findViewById(R.id.addedmedicinetypeEditText)
        AddedmedicinetypeEditText.setSelection(medicinetype)
        AddedmedicinetypeEditText.isEnabled = false

        val AddeddurationEditText: EditText =
            AddPrescriptionView.findViewById(R.id.addeddurationEditText)
        AddeddurationEditText.setText(duration)
        AddeddurationEditText.isEnabled = false

        val AddeddurationSpinner: Spinner =
            AddPrescriptionView.findViewById(R.id.addeddurationSpinner)
        AddeddurationSpinner.setSelection(durationSpinner)
        AddeddurationSpinner.isEnabled = false

        val AddedrepetitionEditText: EditText =
            AddPrescriptionView.findViewById(R.id.addedrepetitionEditText)
        AddedrepetitionEditText.setText(repetition)
        AddedrepetitionEditText.isEnabled = false

        val AddedrepetitionSpinner: Spinner =
            AddPrescriptionView.findViewById(R.id.addedrepetitionSpinner)
        AddedrepetitionSpinner.setSelection(repetitionSpinner)
        AddedrepetitionSpinner.isEnabled = false

        val addeddoseEditText: EditText = AddPrescriptionView.findViewById(R.id.addeddoseEditText)
        addeddoseEditText.setText(dose)
        addeddoseEditText.isEnabled = false

        val AddedEditPrescribtionBtn: Button =
            AddPrescriptionView.findViewById(R.id.addedEditPrescribtionBtn)
        AddedEditPrescribtionBtn.setOnClickListener {
            EditView(AddPrescriptionView)
        }

        val AddedSavePrescribtionBtn: Button =
            AddPrescriptionView.findViewById(R.id.addedSavePrescribtionBtn)
        AddedSavePrescribtionBtn.setOnClickListener {
            SaveView(AddPrescriptionView)
        }

        val addedRemovePrescribtionBtn: Button =
            AddPrescriptionView.findViewById(R.id.addedRemovePrescribtionBtn)
        addedRemovePrescribtionBtn.setOnClickListener {
            removeView(AddPrescriptionView)
        }



        LayoutList.addView(AddPrescriptionView)

    }


    private fun removeView(view: View) {
        LayoutList.removeView(view)
    }

    private fun EditView(view: View) {
        view.findViewById<EditText>(R.id.addedmedicineNameEditText).isEnabled = true
        view.findViewById<EditText>(R.id.addedmedicineSterngthEditText).isEnabled = true
        view.findViewById<EditText>(R.id.addedinstructionsEditText).isEnabled = true

        view.findViewById<Spinner>(R.id.addedmedicinetypeEditText).isEnabled = true

        view.findViewById<EditText>(R.id.addeddurationEditText).isEnabled = true
        view.findViewById<Spinner>(R.id.addeddurationSpinner).isEnabled = true

        view.findViewById<EditText>(R.id.addedrepetitionEditText).isEnabled = true
        view.findViewById<Spinner>(R.id.addedrepetitionSpinner).isEnabled = true

        view.findViewById<EditText>(R.id.addeddoseEditText).isEnabled = true

    }

    private fun SaveView(view: View) {
        view.findViewById<EditText>(R.id.addedmedicineNameEditText).isEnabled = false
        view.findViewById<EditText>(R.id.addedmedicineSterngthEditText).isEnabled = false
        view.findViewById<EditText>(R.id.addedinstructionsEditText).isEnabled = false

        view.findViewById<Spinner>(R.id.addedmedicinetypeEditText).isEnabled = false

        view.findViewById<EditText>(R.id.addeddurationEditText).isEnabled = false
        view.findViewById<Spinner>(R.id.addeddurationSpinner).isEnabled = false

        view.findViewById<EditText>(R.id.addedrepetitionEditText).isEnabled = false
        view.findViewById<Spinner>(R.id.addedrepetitionSpinner).isEnabled = false

        view.findViewById<EditText>(R.id.addeddoseEditText).isEnabled = false
    }

}