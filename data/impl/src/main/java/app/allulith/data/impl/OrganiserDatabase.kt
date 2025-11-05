package app.allulith.data.impl

import androidx.room.Database
import androidx.room.RoomDatabase
import app.allulith.data.impl.dao.UserDao
import app.allulith.data.impl.entity.User

@Database(
    entities = [User::class],
    version = 1,
)
abstract class OrganiserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
