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
import com.route.myapplication.hms.ui.NurseUserFragments.NurseUserLogoutFragment
import com.route.myapplication.hms.ui.NurseUserFragments.NurseUserShowVitalSignsFragment

class UserNurseActivity : AppCompatActivity() {

    lateinit var toggle : ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    lateinit var appBarLayout: AppBarLayout
    lateinit var drawerIcon : ImageView
    lateinit var homeIcon : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_nurse)

        drawerLayout =findViewById(R.id.drawerLayout_nurse)
        drawerIcon = findViewById(R.id.drawer_icon_nurse)
        homeIcon = findViewById(R.id.home_icon_nurse)

        drawerIcon.setOnClickListener {
            drawerLayout.open()
        }

        homeIcon.setOnClickListener {
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }
        val navView : NavigationView = findViewById(R.id.nav_view_nurse)
        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
                menuItem->
            menuItem.isChecked=true
            if(menuItem.itemId == R.id.nav_add_vital_sign_nurse)
            {
                pushFragment(NurseUserAddVitalSignFragment(),menuItem.title.toString())

            } else if(menuItem.itemId == R.id.nav_show_vital_sign_nurse)
            {
                pushFragment(NurseUserShowVitalSignsFragment(),menuItem.title.toString())

            } else if(menuItem.itemId == R.id.nav_show_medicines_nurse)
            {
                pushFragment(NurseUserShowMedicineFragment(),menuItem.title.toString())

            }
            else if(menuItem.itemId == R.id.nav_logout_nurse)
            {
                pushFragment(NurseUserLogoutFragment(),menuItem.title.toString())

            }

            return@setNavigationItemSelectedListener true
        }
        navView.setCheckedItem(R.id.nav_add_vital_sign_nurse)
        pushFragment(NurseUserAddVitalSignFragment(),"Add vital sign")

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