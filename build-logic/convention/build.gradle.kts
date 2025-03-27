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
        register("androidLibrary") {
            id = libs.plugins.globaldizajn.androidLibrary.get().pluginId
            implementationClass = "AndroidLibraryPlugin"
        }
        register("buildVariants") {
            id = libs.plugins.globaldizajn.buildVariants.get().pluginId
            implementationClass = "BuildVariantsPlugin"
        }
        register("featureModule") {
            id = libs.plugins.globaldizajn.featureModule.get().pluginId
            implementationClass = "FeatureModulePlugin"
        }
        register("kotlinMultiplatform") {
            id = libs.plugins.globaldizajn.kotlinMultiplatform.get().pluginId
            implementationClass = "KotlinMultiplatformPlugin"
        }
    }
}