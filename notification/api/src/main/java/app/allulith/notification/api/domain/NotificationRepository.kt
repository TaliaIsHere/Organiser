package app.allulith.notification.api.domain

import android.content.Context

interface NotificationRepository {

    fun scheduleExactReminder(context: Context, reminder: Reminder)
}
