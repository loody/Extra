package me.loody.extra

import org.gradle.api.Plugin
import org.gradle.api.Project


class ExtraPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        Project extra = project.rootProject.findProject("extra")
        Project extra_compiler = project.rootProject.findProject("extra-compiler")
        if (extra && extra_compiler) {
            project.dependencies {
                compile extra
                annotationProcessor extra_compiler
            }
        }
    }
}
