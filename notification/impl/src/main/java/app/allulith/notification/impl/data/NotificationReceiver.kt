package app.allulith.notification.impl.data

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.annotation.RequiresPermission
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import app.allulith.notification.api.domain.NotificationConstants
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
        val id = intent.getIntExtra(NotificationConstants.Intent.ID, 0)
        val title = intent.getStringExtra(NotificationConstants.Intent.TITLE)
        val message = intent.getStringExtra(NotificationConstants.Intent.MESSAGE)
        val hour = intent.getIntExtra(NotificationConstants.Intent.HOUR, 0)
        val minute = intent.getIntExtra(NotificationConstants.Intent.MINUTE, 0)

        // Show notification
        val notification = NotificationCompat.Builder(context, NotificationConstants.CHANNEL_ID)
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
