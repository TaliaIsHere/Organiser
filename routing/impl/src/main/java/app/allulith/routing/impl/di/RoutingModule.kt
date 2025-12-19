package app.allulith.routing.impl.di

import app.allulith.routing.impl.destinations.routing.data.RoutingRepositoryImpl
import app.allulith.routing.impl.destinations.routing.domain.RoutingRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RoutingModule {

    @Binds
    @Singleton
    abstract fun bindRepository(
        repository: RoutingRepositoryImpl
    ): RoutingRepository
}
