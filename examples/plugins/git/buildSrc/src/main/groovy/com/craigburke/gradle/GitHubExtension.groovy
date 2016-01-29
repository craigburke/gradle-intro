package com.craigburke.gradle

class GitHubExtension {
    
    Map<String, GitHubRepo> repos = [:]
    
    def methodMissing(String name, args) {
        if (args && args.first() instanceof String) {
            def (user, repo) = args.first().toString().split('/')
            repos[name] = new GitHubRepo(user: user, repo: repo)
        }
    }
}