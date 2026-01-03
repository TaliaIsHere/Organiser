package app.allulith.organiser

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
internal class OrganiserApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val channel = NotificationChannel(
            ID,
            NAME,
            NotificationManager.IMPORTANCE_HIGH
        )
        getSystemService(NotificationManager::class.java)
            .createNotificationChannel(channel)
    }

    private companion object {
        const val ID = "reminder_channel"
        const val NAME = "Reminders"
    }
}
