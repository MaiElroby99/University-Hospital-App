package com.route.myapplication.hms.ui.DoctorUserFragments

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.NavDeepLinkBuilder
import com.route.myapplication.hms.R
import com.route.myapplication.hms.ui.Menufragments.AddDoctorFragment
import com.route.myapplication.hms.ui.Menufragments.ScheduleNotificationFragment
import com.route.myapplication.hms.ui.UserNurseActivity


class NurseUserShowMedicineFragment : Fragment() {

    lateinit var notificationNurseBtn : Button
    lateinit var scheduleNotificationNurseBtn : Button
    val CHANNEL_ID = "channelId"
    val CHANNEL_NAME = "channelName"
    val NOTIFICATION_ID = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nurse_user_notification, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notificationNurseBtn = requireView().findViewById(R.id.nurse_btn_notification)
        scheduleNotificationNurseBtn = requireView().findViewById(R.id.nurse_btn_schedule_notification)
        createNotificationChannel()

        val intent = Intent(requireContext(),UserNurseActivity::class.java)
        val pendingIntent = TaskStackBuilder.create(requireContext()).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }

        val notification = NotificationCompat.Builder(requireContext(), CHANNEL_ID)
            .setContentTitle("Awesome Notification")
            .setContentText("This is the content text")
            .setSmallIcon(R.drawable.ic_star)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .build()

        val notificationManager = NotificationManagerCompat.from(requireContext())

        notificationNurseBtn.setOnClickListener {
            notificationManager.notify(NOTIFICATION_ID, notification)
        }
        scheduleNotificationNurseBtn.setOnClickListener{
            getParentFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, ScheduleNotificationFragment())
                .addToBackStack("")
                .commit()
        }

    }

    fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(CHANNEL_ID,CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT).apply {
                lightColor = Color.GREEN
                enableLights(true)
            }
            val manger = getActivity()?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manger.createNotificationChannel(channel)
        }
    }

    }