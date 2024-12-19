package com.anugrah.belajarkotlin.jobsheet9notificaton

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.anugrah.belajarkotlin.R
import me.leolin.shortcutbadger.ShortcutBadger
import java.util.*

class NotificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        val buttonSetAlarm = findViewById<Button>(R.id.buttonSetAlarm)
        buttonSetAlarm.setOnClickListener {
            setAlarmNotification()
        }

        val buttonStartService = findViewById<Button>(R.id.buttonStartService)
        buttonStartService.setOnClickListener {
            val serviceIntent = Intent(this, NotificationService::class.java)
            startService(serviceIntent)
        }
    }

    override fun onResume() {
        super.onResume()
        // Reset badge count when app is opened
        BadgeCounterManager.resetBadgeCount(this)
        ShortcutBadger.removeCount(this)
    }

    private fun setAlarmNotification() {
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            this,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val triggerTime = Calendar.getInstance().apply {
            add(Calendar.SECOND, 5)
        }.timeInMillis

        alarmManager.setExact(AlarmManager.RTC_WAKEUP, triggerTime, pendingIntent)
        Toast.makeText(this, "Alarm set for 5 seconds", Toast.LENGTH_SHORT).show()
    }
}
