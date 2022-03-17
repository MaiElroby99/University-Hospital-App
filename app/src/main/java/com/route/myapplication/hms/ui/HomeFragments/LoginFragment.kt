package com.route.myapplication.hms.ui.HomeFragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.route.myapplication.hms.R
import com.route.myapplication.hms.ui.DashboardActivity
import com.route.myapplication.hms.ui.Menufragments.AddDoctorFragment
import com.route.myapplication.hms.ui.UserDoctorActivity
import com.route.myapplication.hms.ui.api.ApiManager
import com.route.myapplication.hms.ui.api.Model.LoginRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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
            if(id_input.text.toString().trim().length > 0){
                userLogin()
                }else{
                Toast.makeText(requireContext(),"Username / Password Required",Toast.LENGTH_LONG).show()
                }



//            if (id_input.text.toString() == "admin" && pass_input.text.toString() == "123") {
//                val intent_admin = Intent(context, DashboardActivity::class.java)
//                startActivity(intent_admin)
//
//            } else if (id_input.text.toString() == "doctor" && pass_input.text.toString() == "123") {
//                val intent_doctor = Intent(context, UserDoctorActivity::class.java)
//                startActivity(intent_doctor)
//            }
        }

    }

    private fun userLogin() {
        val loginRequest = LoginRequest(id_input.text.toString(),pass_input.text.toString())

        ApiManager.getApis().userLogin(loginRequest).enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                Toast.makeText(requireContext(),"Throwable"+t.localizedMessage,Toast.LENGTH_LONG).show()

            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                if(response.isSuccessful){
                    val intent_doctor = Intent(context, UserDoctorActivity::class.java)
                    startActivity(intent_doctor)

                }
            }
        } )
    }
}