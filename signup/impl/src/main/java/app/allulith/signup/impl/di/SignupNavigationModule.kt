package app.allulith.signup.impl.di

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import app.allulith.signup.impl.signUpNavigation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(ActivityRetainedComponent::class)
internal object SignupNavigationModule {

    @IntoSet
    @Provides
    fun providesSignupNavigation() : EntryProviderScope<NavKey>.(SnapshotStateList<NavKey>) -> Unit = { backStack ->
        signUpNavigation(backStack = backStack)
    }
}
