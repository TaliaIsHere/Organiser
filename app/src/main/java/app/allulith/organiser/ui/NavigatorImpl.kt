package app.allulith.organiser.ui

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation3.runtime.NavKey
import app.allulith.navigation.api.Navigator

internal class NavigatorImpl(private val backstack: SnapshotStateList<NavKey>) : Navigator {
    override fun addScreen(key: NavKey) {
        backstack.add(key)
    }

    override fun removeScreen() {
        backstack.removeLastOrNull()
    }
}
