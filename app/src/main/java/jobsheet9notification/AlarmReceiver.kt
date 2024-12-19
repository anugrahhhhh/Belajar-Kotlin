package com.anugrah.belajarkotlin.jobsheet9notificaton

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.anugrah.belajarkotlin.R
import me.leolin.shortcutbadger.ShortcutBadger

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Create Notification Channel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "ALARM_CHANNEL_ID",
                "Alarm Notifications",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Channel for alarm notifications"
                enableLights(true)
                enableVibration(true)
            }
            notificationManager.createNotificationChannel(channel)
        }

        // Increment badge count
        BadgeCounterManager.incrementBadgeCount(context)
        val currentBadgeCount = BadgeCounterManager.getBadgeCount(context)

        // Create Notification
        val notification = NotificationCompat.Builder(context, "ALARM_CHANNEL_ID")
            .setSmallIcon(R.drawable.ic_alarm)
            .setContentTitle("Alarm Triggered!")
            .setContentText("This is your alarm notification.")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .setNumber(currentBadgeCount) // Display badge number
            .setBadgeIconType(NotificationCompat.BADGE_ICON_LARGE)
            .build()

        // Show notification
        notificationManager.notify(1001, notification)

        // Update badge count
        ShortcutBadger.applyCount(context, currentBadgeCount)
    }
}
