package app.allulith.organiser

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import app.allulith.notification.api.domain.NotificationConstants
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
internal class OrganiserApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val channel = NotificationChannel(
            NotificationConstants.CHANNEL_ID,
            NAME,
            NotificationManager.IMPORTANCE_HIGH
        )
        getSystemService(NotificationManager::class.java)
            .createNotificationChannel(channel)
    }

    private companion object {
        const val NAME = "Reminders"
    }
}
