package com.route.myapplication.hms.ui

import android.content.Intent
import android.icu.text.CaseMap
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.navigation.NavigationView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.AppBarLayout
import com.route.myapplication.hms.R
import com.route.myapplication.hms.ui.Menufragments.*


class DashboardActivity : AppCompatActivity() {
    lateinit var toggle : ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    lateinit var appBarLayout: AppBarLayout
    lateinit var drawerIcon : ImageView
    lateinit var homeIcon : ImageView

//    lateinit var dashboard : View
//    lateinit var doctors : View
//    lateinit var nurses : View
//    lateinit var patients : View
//    lateinit var staffMembers : View
//    lateinit var reports : View
//    lateinit var logout : View



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        drawerLayout =findViewById(R.id.drawerLayout)
        drawerIcon = findViewById(R.id.drawer_icon)
        homeIcon = findViewById(R.id.home_icon)

//        dashboard=findViewById(R.id.dashboard)
//        doctors=findViewById(R.id.doctors)
//        nurses=findViewById(R.id.nurses)
//        patients=findViewById(R.id.patients)
//        staffMembers=findViewById(R.id.staffmembers)
//        reports=findViewById(R.id.reports)
//        logout=findViewById(R.id.logout)
        drawerIcon.setOnClickListener {
            drawerLayout.open()
        }

        homeIcon.setOnClickListener {
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }
//
//
//        dashboard.setOnClickListener {
//            pushFragment(DashboardFragment())
//        }
//        doctors.setOnClickListener {
//            pushFragment(DoctorsFragment())
//        }
//
//        nurses.setOnClickListener {
//            pushFragment(NursesFragment())
//        }
//
//        patients.setOnClickListener {
//            pushFragment(PatientsFragment())
//
//        }
//
//        staffMembers.setOnClickListener {
//            pushFragment(StaffMembersFragment())
//
//        }
//
//        reports.setOnClickListener {
//            pushFragment(ReportsFragment())
//        }
//        logout.setOnClickListener {
//            pushFragment(LogoutFragment())
//        }
        val navView : NavigationView = findViewById(R.id.nav_view)
        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeEnabled(true)

        navView.setNavigationItemSelectedListener {
                menuItem->
            menuItem.isChecked=true
            if(menuItem.itemId == R.id.nav_dashboard)
            {
                pushFragment(DashboardFragment(),menuItem.title.toString())

            } else if(menuItem.itemId == R.id.nav_doctor)
            {
                pushFragment(DoctorsFragment(),menuItem.title.toString())

            } else if(menuItem.itemId == R.id.nav_nurses)
            {
                pushFragment(NursesFragment(),menuItem.title.toString())

            }
            else if(menuItem.itemId == R.id.nav_patients)
            {
                pushFragment(PatientsFragment(),menuItem.title.toString())

            }
            else if(menuItem.itemId == R.id.nav_staffmembers)
            {
                pushFragment(StaffMembersFragment(),menuItem.title.toString())

            }
            else if(menuItem.itemId == R.id.nav_reports)
            {
                pushFragment(ReportsFragment(),menuItem.title.toString())

            }
            else if(menuItem.itemId == R.id.nav_logout)
            {
                pushFragment(LogoutFragment(),menuItem.title.toString())

            }
            return@setNavigationItemSelectedListener true
        }

    }

    private fun pushFragment(fragment: Fragment,title:String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack("")
            .commit()
        setTitle(title)
        drawerLayout.close()

    }

    }

