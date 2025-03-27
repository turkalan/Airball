import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.globaldizajn.featureModule)
    alias(libs.plugins.globaldizajn.kotlinMultiplatform)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_18)
        }
    }
    sourceSets {
        val desktopMain by getting

        androidMain.dependencies {
            api(compose.preview)
            api(libs.androidx.activity.compose)
        }
        commonMain.dependencies {
            api(compose.runtime)
            api(compose.foundation)
            api(compose.material)
            api(compose.ui)
            api(compose.components.resources)
            api(compose.components.uiToolingPreview)
            api(compose.materialIconsExtended)
            @OptIn(ExperimentalComposeLibrary::class)
            api(compose.uiTest)
        }
        desktopMain.dependencies {
            api(compose.desktop.currentOs)
            api(libs.kotlinx.coroutines.swing)
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.material)
}