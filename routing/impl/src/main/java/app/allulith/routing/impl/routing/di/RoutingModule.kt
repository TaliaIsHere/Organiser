package app.allulith.routing.impl.routing.di

import app.allulith.routing.impl.routing.data.RoutingRepositoryImpl
import app.allulith.routing.impl.routing.domain.RoutingRepository
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
