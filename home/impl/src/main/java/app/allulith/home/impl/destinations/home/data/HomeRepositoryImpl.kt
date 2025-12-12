package app.allulith.home.impl.destinations.home.data

import app.allulith.data.impl.OrganiserDatabase
import app.allulith.home.impl.destinations.home.domain.HomeRepository
import app.allulith.home.impl.destinations.home.domain.NameNotFound
import arrow.core.Either
import arrow.core.left
import arrow.core.right
import javax.inject.Inject

internal class HomeRepositoryImpl @Inject constructor(
    private val database: OrganiserDatabase,
) : HomeRepository {

    override suspend fun getUserName(): Either<NameNotFound, String> {
        val name = database.userDao().getAll().firstOrNull()?.name
        return name?.right() ?: NameNotFound.left()
    }
}
