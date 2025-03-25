package com.kobayagi.buildlogic.convention.extensions

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

val Project.libs: VersionCatalog
    get() = extensions.getByType<VersionCatalogsExtension>().named(CATALOG_NAME)

fun VersionCatalog.library(name: String) = findLibrary(name).get()

fun VersionCatalog.version(name: String) = findVersion(name).get().requiredVersion

private const val CATALOG_NAME = "libs"