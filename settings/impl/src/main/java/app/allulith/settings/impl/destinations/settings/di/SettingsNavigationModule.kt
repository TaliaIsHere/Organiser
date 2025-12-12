package app.allulith.settings.impl.destinations.settings.di

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import app.allulith.navigation.api.Navigator
import app.allulith.settings.impl.settingsNavigationBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.multibindings.IntoSet


@Module
@InstallIn(ActivityRetainedComponent::class)
internal object SettingsNavigationModule {

    @IntoSet
    @Provides
    fun provideSettingsNavigation() : EntryProviderScope<NavKey>.(Navigator) -> Unit = { navigator ->
        settingsNavigationBuilder(navigator = navigator)
    }
}
