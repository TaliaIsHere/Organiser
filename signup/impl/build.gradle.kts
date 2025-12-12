import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
}

android {
    namespace = "app.allulith.signup.impl"
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
    api(project(":signup:api"))

    implementation(project(":home:api"))
    implementation(project(":data:impl"))
    implementation(project(":ui:impl"))
    implementation(project(":navigation:api"))

    implementation(libs.bundles.core.ui)
    implementation(libs.bundles.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.bundles.navigation)
    implementation(libs.bundles.hilt)
    implementation(libs.bundles.persistence)

    ksp(libs.hilt.ksp)
    ksp(libs.bundles.hilt)
    ksp(libs.room.compiler)
}
