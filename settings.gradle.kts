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
include(":home")
include(":home:api")
include(":home:impl")
include(":tasks")
include(":tasks:api")
include(":tasks:impl")
include(":goals")
include(":goals:api")
include(":goals:impl")
include(":signup")
include(":signup:api")
include(":signup:impl")
include(":routing")
include(":routing:api")
include(":routing:impl")
include(":settings")
include(":settings:api")
include(":settings:impl")
include(":notification")
include(":notification:api")
include(":notification:impl")
