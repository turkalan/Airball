package com.kobayagi.buildlogic.convention

import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidLibraryPlugin: Plugin<Project> {
    override fun apply(project: Project) {
        project.run {
            applyPlugins(this)
        }
    }

    private fun applyPlugins(project: Project) = with(project.pluginManager) {
        apply {
            apply("com.android.library")
            apply("kotlin-android")
        }
    }
}