import extensions.kotlin
import extensions.libs
import extensions.moduleName
import org.gradle.api.Plugin
import org.gradle.api.Project

class KotlinMultiplatformPlugin: Plugin<Project> {
    override fun apply(project: Project)  = with(project) {
        applyPlugins()
        configureMultiplatform()
        configureSourceSet()
    }

    private fun Project.applyPlugins() {
        plugins.apply(libs.findPlugin("kotlinMultiplatform").get().get().pluginId)
    }

    private fun Project.configureSourceSet() {
        kotlin {
            sourceSets.configureEach {
                when (name) {
                    commonMain -> dependencies {
                        implementation(libs.findLibrary("koin.core").get().get())
                    }
                }
            }
        }
    }

    private fun Project.configureMultiplatform() {
        kotlin {
            listOf(
                iosX64(),
                iosArm64(),
                iosSimulatorArm64()
            ).forEach {
                it.binaries.framework {
                    baseName = moduleName
                    isStatic = true
                }
            }
            jvm(DESKTOP)
        }
    }

    private companion object {
        const val DESKTOP = "desktop"
    }
}