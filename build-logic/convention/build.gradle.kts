plugins {
    `kotlin-dsl`
}

dependencies {
    compileOnly(libs.kotlin.gradle.plugin)
    compileOnly(libs.android.gradle.plugin)
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("AndroidLibraryPlugin") {
            id = "airball.android.library.plugin"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
    }
}