package com.example.androidintentservicedemo

import android.R
import android.app.IntentService
import android.app.Notification
import android.app.NotificationManager
import android.content.Intent
import androidx.core.app.NotificationCompat
import java.util.concurrent.TimeUnit


class MyIntentService(name: String = "") : IntentService(name) {

    override fun onHandleIntent(intent: Intent?) {

        val bundle = intent?.getBundleExtra("bundle")

        val time = bundle?.get("time") as Long
        val msg = bundle.get("message") as String

        try {
            TimeUnit.SECONDS.sleep(time)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        val notification: Notification = NotificationCompat
            .Builder(this, "test notification channel")
            .setContentTitle(msg)
            .setContentText(msg)
            .setTicker(msg)
            .setSmallIcon(R.drawable.stat_sys_headset)
            .build()

        val notificationManager =
            getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.notify(0, notification)

    }

}