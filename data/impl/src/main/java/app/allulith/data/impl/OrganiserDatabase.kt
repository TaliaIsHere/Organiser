package app.allulith.data.impl

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import app.allulith.data.impl.dao.UserDao
import app.allulith.data.impl.entity.User

@Database(
    entities = [User::class],
    version = 1,
)
abstract class OrganiserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: OrganiserDatabase? = null
        private const val DATABASE_NAME = "organiser-database"

        fun getInstance(context: Context): OrganiserDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    OrganiserDatabase::class.java,
                    DATABASE_NAME
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
