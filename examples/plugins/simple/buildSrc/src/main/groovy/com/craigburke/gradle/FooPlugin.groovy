package com.craigburke.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

class FooPlugin implements Plugin<Project> {

    void apply(Project project) {
        FooExtension config = project.extensions.create('foo', FooExtension)
        
        project.task('showMessage', group: 'Foo') {
            doLast {
                println "\nMessage: ${config.message}\n"
            }
        }
        
    }

}
