package app.allulith.home.impl.destinations.home.di

import app.allulith.home.impl.destinations.home.data.HomeRepositoryImpl
import app.allulith.home.impl.destinations.home.domain.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class HomeModule {

    @Binds
    @Singleton
    abstract fun bindRepository(
        repository: HomeRepositoryImpl
    ): HomeRepository
}
