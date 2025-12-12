import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "app.allulith.routing.impl"
    compileSdk {
        version = release(36)
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlin {
        compilerOptions {
            jvmTarget = JvmTarget.JVM_11
        }
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    api(project(":routing:api"))

    implementation(project(":signup:api"))
    implementation(project(":navigation:api"))
    implementation(project(":home:api"))
    implementation(project(":data:impl"))

    implementation(libs.bundles.arrow)
    implementation(libs.bundles.hilt)
    implementation(libs.bundles.persistence)
    implementation(libs.bundles.navigation)

    ksp(libs.hilt.ksp)
    ksp(libs.room.compiler)
}
