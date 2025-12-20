package app.allulith.data.impl.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.allulith.data.impl.entity.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * FROM task")
    fun getAll(): Flow<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg tasks: Task)

    @Delete
    suspend fun delete(task: Task)
}
