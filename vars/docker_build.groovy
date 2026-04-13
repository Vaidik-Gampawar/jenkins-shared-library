def call(String credsId, String imagename){
    withCredentials([usernamePassword(
        credentialsId: "${credsId}",
        usernameVariable: "dockerHubUser",
        passwordVariable: "dockerHubPass"
    )]){
        sh "docker build -t ${env.dockerHubUser}/${imagename} ."
    }
}