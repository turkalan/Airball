import extensions.androidGradle
import extensions.configureCompileOptions
import extensions.implementation
import extensions.libs
import extensions.modulePackageName
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidLibraryPlugin : Plugin<Project> {
    override fun apply(project: Project) = with(project) {
        applyPlugins()
        androidGradle {
            configureCompileOptions(this)
            namespace = "${libs.findVersion(APPLICATON_ID).get()}.$modulePackageName"
            compileSdk = Integer.parseInt(libs.findVersion(COMPILE_SDK).get().toString())
            defaultConfig.apply {
                lint.targetSdk = Integer.parseInt(libs.findVersion(TARGET_SDK).get().toString())
                minSdk = Integer.parseInt(libs.findVersion(MIN_SDK).get().toString())
            }
            dependencies {
                implementation(libs.findLibrary("coroutines-core").get())
            }
        }
    }
    private fun Project.applyPlugins() {
        pluginManager.apply {
            apply("com.android.library")
            apply(libs.findPlugin("globaldizajn-buildVariants").get().get().pluginId)
        }
    }

    private companion object {
        const val APPLICATON_ID = "applicationId"
        const val COMPILE_SDK = "compileSdk"
        const val TARGET_SDK = "targetSdk"
        const val MIN_SDK = "minSdk"
    }
}