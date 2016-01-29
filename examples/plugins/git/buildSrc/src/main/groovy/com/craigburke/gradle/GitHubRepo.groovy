class GitHubRepo {

    String user
    String repo
    
    String getInfoUrl() {
        "https://api.github.com/repos/${user}/${repo}"
    }
    
    String getRepositoryUrl() {
        "https://github.com/${user}/${repo}.git"
    }
}