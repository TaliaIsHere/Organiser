package app.allulith.navigation.api

import androidx.navigation3.runtime.NavKey

interface Navigator {
    fun addScreen(key: NavKey)
    fun pop()
    fun clearAndAddScreen(key: NavKey)
}
