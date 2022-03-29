package com.route.myapplication.hms

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.route.myapplication.hms.ui.UserNurseActivity

const val channelId = "notification_channel"
const val channelName = "com.route.myapplication.hms"
class MyFirebaseMessagingService : FirebaseMessagingService() {

    // generate the notification
    // attach the notification to the custom layout
    // show the notification


    override fun onMessageReceived(message: RemoteMessage) {
        if (message.getNotification() != null){
            generateNotification(message.notification!!.title!!,message.notification!!.body!!)
        }
    }


    @SuppressLint("RemoteViewLayout")
    fun getRemoteView(title: String,message: String):RemoteViews{
        val remoteView = RemoteViews("com.route.myapplication.hms",R.layout.notification)

        remoteView.setTextViewText(R.id.notification_title,title)
        remoteView.setTextViewText(R.id.notification_message,message)
        remoteView.setImageViewResource(R.id.notification_logo,R.drawable.hospital_notification_logo)

        return remoteView
    }

    fun generateNotification(title:String,message:String){
        val intent = Intent (this,UserNurseActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        val pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT)

        //channel id & channel name
        var builder : NotificationCompat.Builder = NotificationCompat.Builder(applicationContext, channelId)
            .setSmallIcon(R.drawable.hospital_notification_logo)
            .setAutoCancel(true)
            .setVibrate(longArrayOf(1000,1000,1000,1000))
            .setOnlyAlertOnce(true)
            .setContentIntent(pendingIntent)
        builder = builder.setContent(getRemoteView(title,message))

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val notificationChannel = NotificationChannel(channelId, channelName,NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)
        }

        notificationManager.notify(0,builder.build())

    }
}