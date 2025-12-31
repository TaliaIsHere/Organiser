package app.allulith.tasks.api.domain

import androidx.compose.runtime.Immutable

@Immutable
data class Task(
    val id: String,
    val title: String,
    val description: String?,
)
