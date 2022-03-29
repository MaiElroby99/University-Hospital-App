package com.route.myapplication.hms.ui.HomeFragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.route.myapplication.hms.R
import com.route.myapplication.hms.ui.DashboardActivity
import com.route.myapplication.hms.ui.Menufragments.AddDoctorFragment
import com.route.myapplication.hms.ui.UserDoctorActivity
import com.route.myapplication.hms.ui.UserNurseActivity


class LoginFragment : Fragment() {

    lateinit var loginbtn: Button
    lateinit var id_input: EditText
    lateinit var pass_input: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginbtn = requireView().findViewById(R.id.loginbtn)


        id_input = requireView().findViewById(R.id.idInput)
        pass_input = requireView().findViewById(R.id.passInput)


        loginbtn.setOnClickListener {
            if (id_input.text.toString() == "admin" && pass_input.text.toString() == "123") {
                val intent_admin = Intent(context, DashboardActivity::class.java)
                startActivity(intent_admin)

            } else if (id_input.text.toString() == "doctor" && pass_input.text.toString() == "123") {
                val intent_doctor = Intent(context, UserDoctorActivity::class.java)
                startActivity(intent_doctor)
            } else if (id_input.text.toString() == "nurse" && pass_input.text.toString() == "123") {
                val intent_nurse = Intent(context, UserNurseActivity::class.java)
                startActivity(intent_nurse)
            }
        }

    }
}