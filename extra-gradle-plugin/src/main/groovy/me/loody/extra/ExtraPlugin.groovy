package me.loody.extra

import org.gradle.api.Plugin
import org.gradle.api.Project

class ExtraPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.task("testTask") << {
               println("hello gradle plugin")
        }
    }
}
