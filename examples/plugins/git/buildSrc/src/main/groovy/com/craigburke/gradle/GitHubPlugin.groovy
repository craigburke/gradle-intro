package com.craigburke.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

import org.ajoberstar.grgit.Grgit

class GitHubPlugin implements Plugin<Project> {

    void apply(Project project) {
        GitHubExtension config = project.extensions.create('github', GitHubExtension)
        
        project.afterEvaluate {
            config.repos.each { String name, GitHubRepo repo ->
                addTasks(project, name, repo)
            }
        }
    }

    void addTasks(Project project, String name, GitHubRepo repo) {        
        
        project.task("${name}Download", group: "Git") {
            doLast {
                String downloadPath = "${project.buildDir.path}/git/${name}/"
                project.delete(downloadPath)
                def gitRepo = Grgit.clone(dir: downloadPath, uri: repo.repositoryUrl, refToCheckout: 'master')
                println "Cloned ${repo.repositoryUrl} [${gitRepo.head().abbreviatedId}]"
            }
        }
    }


}
