package com.route.myapplication.hms.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.AppBarLayout
import com.route.myapplication.hms.R
import com.route.myapplication.hms.ui.DoctorUserFragments.*
import com.route.myapplication.hms.ui.Menufragments.*

class UserDoctorActivity : AppCompatActivity() {

    lateinit var toggle : ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    lateinit var appBarLayout: AppBarLayout
    lateinit var drawerIcon : ImageView
    lateinit var homeIcon : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_doctor)

        drawerLayout =findViewById(R.id.drawerLayout)
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
            if(menuItem.itemId == R.id.nav_Doctordashboard)
            {
                pushFragment(DoctorUserDashboardFragment(),menuItem.title.toString())

            } else if(menuItem.itemId == R.id.nav_DoctorAppointment)
            {
                pushFragment(DoctorUserAppointmentsFragment(),menuItem.title.toString())

            } else if(menuItem.itemId == R.id.nav_Outpatient)
            {
                pushFragment(DoctorUserOutpatientFragment(),menuItem.title.toString())

            }
            else if(menuItem.itemId == R.id.nav_Inpatient)
            {
                pushFragment(DoctorUserInpatientFragment(),menuItem.title.toString())

            }
            else if(menuItem.itemId == R.id.nav_Doctorlogout)
            {
                pushFragment(DoctorUserLogoutFragment(),menuItem.title.toString())

            }

            return@setNavigationItemSelectedListener true
        }

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