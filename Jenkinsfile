node {  
    stage 'Clone the project'
    git 'https://github.com/aabit/volunteeerocks.git'
    
    stage('Build') { 
        sh "mvn -version"
        sh "mvn clean install"
    }
    stage('Test') { 
        // 
    }
    stage('Deploy') { 
        // 
    }
}