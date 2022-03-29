package com.route.myapplication.hms

import android.app.Notification
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat

const val scheduleNotificationId = 1
const val scheduleChannelId = "channel1"
const val scheduleTitleExtra = "titleExtra"
const val scheduleMessageExtra = "messageExtra"

class Notification : BroadcastReceiver(){
    override fun onReceive(context: Context, intent: Intent) {
        val notification  = NotificationCompat.Builder(context, scheduleChannelId)
            .setSmallIcon(R.drawable.hospital_notification_logo)
            .setContentTitle(intent.getStringExtra(scheduleTitleExtra))
            .setContentText(intent.getStringExtra(scheduleMessageExtra))
            .build()

        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(scheduleNotificationId,notification)
    }
}
