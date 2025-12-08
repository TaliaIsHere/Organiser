package app.allulith.home.impl.destinations.home.domain

import arrow.core.Either

internal interface HomeRepository {
    suspend fun getUserName(): Either<NameNotFound, String>
}
