def call(String credsId, String imagename){
    withCredentials([usernamePassword(
        credentialsId: "${credsId}",
        usernameVariable: "dockerHubUser",
        passwordVariable: "dockerHubPass"
    )]){
        docker build -t ${env.dockerHubUser}/${imagename} .
    }
}