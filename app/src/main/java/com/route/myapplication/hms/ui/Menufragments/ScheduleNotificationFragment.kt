package com.route.myapplication.hms.ui.Menufragments

import android.app.*
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.os.Build
import android.os.Bundle
import java.util.Calendar
import android.text.format.DateFormat.getLongDateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import com.google.android.material.timepicker.TimeFormat
import com.route.myapplication.hms.*
import com.route.myapplication.hms.Notification
import com.route.myapplication.hms.databinding.FragmentScheduleNotificationBinding
import com.route.myapplication.hms.ui.UserNurseActivity
import java.text.DateFormat
import java.util.*

class ScheduleNotificationFragment:Fragment(R.layout.fragment_schedule_notification) {
    private var _binding : FragmentScheduleNotificationBinding?=null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentScheduleNotificationBinding.inflate(inflater,container,false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createNotificationChannel()
        binding.scheduleNotificationSubmitBtn.setOnClickListener{scheduleNotification()}
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun scheduleNotification() {
        val intent = Intent(requireContext(),Notification::class.java)
        val title = binding.scheduleNotificationTitleET.text.toString()
        val message = binding.scheduleNotificationMessageET.text.toString()
        intent.putExtra(scheduleTitleExtra,title)
        intent.putExtra(scheduleMessageExtra,message)

        val pendingIntent = PendingIntent.getBroadcast(
            requireContext(),
            scheduleNotificationId,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        val alarmManager = getActivity()?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val time = getTime()
        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            time,
            pendingIntent
        )

        showAlert(time,title,message)

    }

    private fun showAlert(time: Long, title: String, message: String) {
        val date = Date(time)
        val dateFormat = android.text.format.DateFormat.getLongDateFormat(requireContext())
        val timeFormat = android.text.format.DateFormat.getTimeFormat(requireContext())

        AlertDialog.Builder(requireContext())
            .setTitle("Notification Scheduled")
            .setMessage(
                        "Title: " + title +
                        "\nMessage: " + message +
                        "\nAt: " + dateFormat.format(date) + " " + timeFormat.format(date)
            )
            .setPositiveButton("Okay"){_,_,->}
            .show()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun getTime(): Long {
        val minute = binding.scheduleNotificationTimePicker.minute
        val hour = binding.scheduleNotificationTimePicker.hour
        val day = binding.scheduleNotificationDatePicker.dayOfMonth
        val month = binding.scheduleNotificationDatePicker.month
        val year = binding.scheduleNotificationDatePicker.year

        val calender = Calendar.getInstance()
        calender.set(year,month,day,hour,minute)
        return calender.timeInMillis

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel() {
        val name = "notification name"
        val desc = "a description of the notification"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(scheduleChannelId,name,importance)
        channel.description = desc
        val notificationManager = getActivity()?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
