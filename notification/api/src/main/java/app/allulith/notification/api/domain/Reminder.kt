package app.allulith.notification.api.domain

data class Reminder(
    val id: Int,
    val hour: Int,
    val minute: Int,
    val title: String?,
    val message: String?,
)
