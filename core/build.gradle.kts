import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kobayagi.androidLibrary)
    alias(libs.plugins.kobayagi.kotlinMultiplatform)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_18)
        }
    }
    sourceSets {
        val desktopMain by getting
        androidMain.dependencies {}
        commonMain.dependencies {
            implementation(projects.common.core)
        }
        desktopMain.dependencies {
            api(libs.kotlinx.coroutines.swing)
        }
    }
}