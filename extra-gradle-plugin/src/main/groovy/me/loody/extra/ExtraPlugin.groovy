package me.loody.extra

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ExtraPropertiesExtension


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
        } else {
            String extraVersion = "0.1.1"
            String extraCompilerVersion = "0.1.1"
            ExtraPropertiesExtension ext = project.rootProject.ext
            if (ext.has("extraVersion")) {
                extraVersion = ext.get("extraVersion")
            }
            if (ext.has("extraCompilerVersion")) {
                extraCompilerVersion = ext.get("extraCompilerVersion")
            }


            project.dependencies.add("compile", "me.loody:extra:${extraVersion}")
            project.dependencies.add("annotationProcessor", "me.loody:extra-compiler:${extraCompilerVersion}")
        }
    }
}
