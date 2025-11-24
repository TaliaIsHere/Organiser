pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Organiser"
include(":app")
include(":ui")
include(":ui:impl")
include(":data")
include(":data:impl")
include(":signup")
include(":signup:impl")
include(":navigation")
include(":navigation:api")
include(":routing")
include(":routing:api")
include(":routing:impl")
