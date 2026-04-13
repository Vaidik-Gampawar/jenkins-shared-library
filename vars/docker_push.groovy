def call(String credsId, String imagename){
    withCredentials([usernamePassword(
        credentialsId: "${credsId}",
        usernameVariable: "dockerHubUser",
        passwordVariable: "dockerHubPass"
    )]){
        sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
        sh "docker push ${env.dockerHubUser}/${imagename}"
    }
}