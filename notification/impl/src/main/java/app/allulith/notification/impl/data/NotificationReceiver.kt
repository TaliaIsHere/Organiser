package app.allulith.notification.impl.data

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.annotation.RequiresPermission
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import app.allulith.notification.api.domain.NotificationRepository
import app.allulith.notification.api.domain.Reminder
import app.allulith.notification.impl.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
internal class NotificationReceiver : BroadcastReceiver() {

    @Inject
    lateinit var repository: NotificationRepository

    @RequiresPermission(allOf = [Manifest.permission.POST_NOTIFICATIONS, Manifest.permission.SCHEDULE_EXACT_ALARM])
    override fun onReceive(context: Context, intent: Intent) {
        val id = intent.getIntExtra("id", 0)
        val title = intent.getStringExtra("title") ?: "Reminder"
        val message = intent.getStringExtra("message") ?: "It's time!"
        val hour = intent.getIntExtra("hour", 0)
        val minute = intent.getIntExtra("minute", 0)

        // Show notification
        val notification = NotificationCompat.Builder(context, "reminder_channel")
            .setContentTitle(title)
            .setContentText(message)
            .setSmallIcon(R.drawable.ic_notification)
            .build()

        NotificationManagerCompat.from(context).notify(id, notification)

        repository.scheduleExactReminder(
            context = context,
            reminder = Reminder(id, hour, minute, title, message)
        )
    }
}
