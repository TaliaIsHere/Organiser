package app.allulith.organiser.data

import app.allulith.data.impl.OrganiserDatabase
import app.allulith.data.impl.entity.User
import app.allulith.organiser.domain.OrganiserRepository
import javax.inject.Inject

internal class OrganiserRepositoryImpl @Inject constructor(
    private val database: OrganiserDatabase,
) : OrganiserRepository {

    override suspend fun getUser(): User? {
        return database.userDao().getAll().firstOrNull()
    }
}
