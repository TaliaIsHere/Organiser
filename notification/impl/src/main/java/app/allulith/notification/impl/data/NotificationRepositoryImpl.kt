package app.allulith.notification.impl.data

import android.Manifest
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.annotation.RequiresPermission
import app.allulith.notification.api.domain.NotificationRepository
import app.allulith.notification.api.domain.Reminder
import java.util.Calendar
import javax.inject.Inject

internal class NotificationRepositoryImpl @Inject constructor() : NotificationRepository {

    @RequiresPermission(Manifest.permission.SCHEDULE_EXACT_ALARM)
    override fun scheduleExactReminder(
        context: Context,
        reminder: Reminder,
    ) {
        val calendar = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, reminder.hour)
            set(Calendar.MINUTE, reminder.minute)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)

            // If time has passed today, schedule for tomorrow
            if (timeInMillis <= System.currentTimeMillis()) {
                add(Calendar.DAY_OF_YEAR, 1)
            }
        }

        val intent = Intent(context, NotificationReceiver::class.java).apply {
            putExtra("id", reminder.id)
            putExtra("title", reminder.title)
            putExtra("message", reminder.message)
            putExtra("hour", reminder.hour)
            putExtra("minute", reminder.minute)
        }

        val pendingIntent = PendingIntent.getBroadcast(
            context,
            reminder.id, // unique per reminder
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val alarmManager = context.getSystemService(AlarmManager::class.java)
        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            pendingIntent
        )
    }

}
