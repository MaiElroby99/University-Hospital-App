package com.route.myapplication.hms.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.navigation.NavigationView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.AppBarLayout
import com.route.myapplication.hms.R
import com.route.myapplication.hms.ui.DoctorUserFragments.*

class UserDoctorActivity : AppCompatActivity() {

    lateinit var toggle : ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    lateinit var appBarLayout: AppBarLayout
    lateinit var drawerIcon : ImageView
    lateinit var homeIcon : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_doctor)

        drawerLayout =findViewById(R.id.drawerLayout_doctor)
        drawerIcon = findViewById(R.id.drawer_icon)
        homeIcon = findViewById(R.id.home_icon)

        drawerIcon.setOnClickListener {
            drawerLayout.open()
        }

        homeIcon.setOnClickListener {
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }
        val navView : NavigationView = findViewById(R.id.nav_view)
        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
                menuItem->
            menuItem.isChecked=true
            if(menuItem.itemId == R.id.nav_dashboard_doctor)
            {
                pushFragment(DoctorUserDashboardFragment(),menuItem.title.toString())

            } else if(menuItem.itemId == R.id.nav_appointment_doctor)
            {
                pushFragment(DoctorUserAppointmentsFragment(),menuItem.title.toString())

            } else if(menuItem.itemId == R.id.nav_outpatient_doctor)
            {
                pushFragment(DoctorUserOutpatientFragment(),menuItem.title.toString())

            }
            else if(menuItem.itemId == R.id.nav_inpatient_doctor)
            {
                pushFragment(DoctorUserInpatientFragment(),menuItem.title.toString())

            }
            else if(menuItem.itemId == R.id.nav_logout_doctor)
            {
                pushFragment(DoctorUserLogoutFragment(),menuItem.title.toString())

            }

            return@setNavigationItemSelectedListener true
        }
        navView.setCheckedItem(R.id.nav_dashboard_doctor)
        pushFragment(DoctorUserDashboardFragment(),"dashboard")

    }

    private fun pushFragment(fragment: Fragment, title:String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack("")
            .commit()
        setTitle(title)
        drawerLayout.close()

    }

}