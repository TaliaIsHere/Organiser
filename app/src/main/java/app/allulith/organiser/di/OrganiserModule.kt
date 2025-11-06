package app.allulith.organiser.di

import app.allulith.organiser.data.OrganiserRepositoryImpl
import app.allulith.organiser.domain.OrganiserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class OrganiserModule {

    @Binds
    @Singleton
    abstract fun bindRepository(
        repository: OrganiserRepositoryImpl
    ): OrganiserRepository
}
