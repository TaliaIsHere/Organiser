package app.allulith.data.impl.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey val uid: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String?,
)
