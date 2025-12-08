package app.allulith.signup.impl.di

import app.allulith.signup.impl.destinations.accountCreation.data.AccountCreationRepositoryImpl
import app.allulith.signup.impl.destinations.accountCreation.domain.AccountCreationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class AccountCreationModule {

    @Binds
    @Singleton
    abstract fun bindRepository(
        repository: AccountCreationRepositoryImpl
    ): AccountCreationRepository
}
