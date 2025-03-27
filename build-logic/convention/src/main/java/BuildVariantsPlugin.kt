import com.android.build.gradle.AppExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.TestedExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class BuildVariantsPlugin : Plugin<Project> {
    override fun apply(project: Project) = with(project.plugins) {
        withId("com.android.application") {
            configureVariants(project.extensions.getByType(AppExtension::class.java))
        }
        withId("com.android.library") {
            configureVariants(project.extensions.getByType(LibraryExtension::class.java))
        }
    }
    
    private fun configureVariants(extension: TestedExtension) {
        when (extension) {
            is AppExtension -> {
                // place to add flavors
               extension.apply { 
                   buildTypes {
                       getByName(DEBUG_BUILD_TYPE) {
                           isMinifyEnabled = false
                           isDebuggable = true
                       }
                       getByName(RELEASE_BUILD_TYPE) {
                           isMinifyEnabled = true
                           isShrinkResources = true
                           isDebuggable = false
                       }
                   }
               }
            }
            else -> Unit
        }
    }

    private companion object {
        const val DEBUG_BUILD_TYPE = "debug"
        const val RELEASE_BUILD_TYPE = "release"
    }
}