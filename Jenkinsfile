pipeline {  
    agent any

    tools
    {
      maven "3.6.3"
    }
    
    stages
    {
      stage('Build') { 
          sh "mvn -version"
          sh "mvn clean install"
      }
    }
  
  post
  {
    always
    {
      cleanWs()
    }
  }

}