package com.route.myapplication.hms.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.route.myapplication.hms.R
import com.route.myapplication.hms.ui.HomeFragments.*

class HomeActivity : AppCompatActivity() {
        lateinit var bottomNavigation : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNavigation = findViewById(R.id.navigation_bar)
        bottomNavigation.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener{
                menuItem->
            if(menuItem.itemId == R.id.navigation_home)
            {
                pushFragment(HomeFragment())

            } else if(menuItem.itemId == R.id.navigation_doctors)
            {
                pushFragment(DoctorFragment())

            } else if(menuItem.itemId == R.id.navigation_clinic)
            {
                pushFragment(ClincFragment())

            }
//            else if(menuItem.itemId == R.id.navigation_services)
//            {
//                pushFragment(ServicesFragment())
//
//            }
            else if(menuItem.itemId == R.id.navigation_appointment)
            {
                pushFragment(AppointmentFragment())

            }
            else if(menuItem.itemId == R.id.navigation_login)
            {
                pushFragment(LoginFragment())

            }
            return@OnItemSelectedListener true;
        })
        bottomNavigation.selectedItemId = R.id.navigation_home
    }

    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()

    }

}