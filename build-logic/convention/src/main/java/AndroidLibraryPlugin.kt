import extensions.androidGradle
import extensions.configureCompileOptions
import extensions.kotlin
import extensions.libs
import extensions.modulePackageName
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidLibraryPlugin : Plugin<Project> {
    override fun apply(project: Project) = with(project) {
        applyPlugins()
        configureSourceSet()
        androidGradle {
            configureCompileOptions(this)
            namespace = "${libs.findVersion(APPLICATON_ID).get()}.$modulePackageName"
            compileSdk = Integer.parseInt(libs.findVersion(COMPILE_SDK).get().toString())
            defaultConfig.apply {
                lint.targetSdk = Integer.parseInt(libs.findVersion(TARGET_SDK).get().toString())
                minSdk = Integer.parseInt(libs.findVersion(MIN_SDK).get().toString())
            }
        }
    }
    private fun Project.applyPlugins() {
        pluginManager.apply {
            apply("com.android.library")
            apply(libs.findPlugin("kobayagi-kotlinMultiplatform").get().get().pluginId)
            apply(libs.findPlugin("kobayagi-buildVariants").get().get().pluginId)
//            apply(libs.findPlugin("kotlinSerialization").get().get().pluginId)
        }
    }

    private fun Project.configureSourceSet() {
        kotlin {
            sourceSets.configureEach {
                when(name) {
                    commonMain -> dependencies {
                        implementation(libs.findLibrary("coroutines.core").get().get())
//                        implementation(libs.findLibrary("kotlinx.serialization").get().get())
                    }
                }
            }
        }
    }

    private companion object {
        const val APPLICATON_ID = "applicationId"
        const val COMPILE_SDK = "compileSdk"
        const val TARGET_SDK = "targetSdk"
        const val MIN_SDK = "minSdk"
    }
}