package extensions

import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.internal.extensions.stdlib.capitalized
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

val Project.libs: VersionCatalog
    get() = extensions.getByType<VersionCatalogsExtension>().named(LIBS)

fun configureCompileOptions(extension: CommonExtension<*, *, *, *, *, *>) {
    extension.apply {
        apply {
            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_18
                targetCompatibility = JavaVersion.VERSION_18
            }
        }
    }
}

val Project.moduleName get() = path
    .split(":")
    .filter { it.isNotBlank() }
    .joinToString("") { it.capitalized() }

val Project.modulePackageName get() = path
    .split(":")
    .filter { it.isNotBlank() }
    .joinToString(".") { it.lowercase() }

inline fun Project.androidGradle(crossinline configure: LibraryExtension.() -> Unit) =
    extensions.configure<LibraryExtension> {
        configure()
    }

inline fun Project.kotlin(crossinline configure: KotlinMultiplatformExtension.() -> Unit) =
    extensions.configure<KotlinMultiplatformExtension> {
        configure()
    }

const val implementation = "implementation"
private const val LIBS = "libs"