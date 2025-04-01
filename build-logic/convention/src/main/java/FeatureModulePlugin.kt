import extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class FeatureModulePlugin : Plugin<Project> {
    override fun apply(project: Project) = with(project) {
        applyPlugins()
        configureSourceSet()
    }

    private fun Project.applyPlugins() {
        pluginManager.apply {
            apply(libs.findPlugin("kobayagi-androidLibrary").get().get().pluginId)
            apply(libs.findPlugin("composeMultiplatform").get().get().pluginId)
            apply(libs.findPlugin("composeCompiler").get().get().pluginId)
        }
    }

    private fun Project.configureSourceSet() {
        extensions.configure<KotlinMultiplatformExtension> {
            sourceSets.configureEach {
                when(name) {
                    commonMain -> dependencies {
                        libs.findBundle("koin-compose").get().get().forEach { implementation(it) }
                    }
                }
            }
        }
    }
}