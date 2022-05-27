pipeline {
    agent { label "Master"}
  // agent any

    stages {
        
        stage('Build') {
          
            steps {

             git credentialsId: '2745393e-0cb2-4949-b21e-1b1983873ade', url: 'https://github.com/jyotsnajadaun/CICDDemo.git'

                 }
                        }
    
        
        stage('Test') {
                  parallel {
                     stage('Smoke Test') {
                                    //  agent { label "Master"}
                             steps {

                               withMaven(jdk: 'JAVA_HOME',maven: 'MAVEN_HOME') {
    // some block
    
                             bat 'mvn test -PSmoke'
                                                                                }
    
                                    }
                     }
                                               
                     stage('Regression Test') {
                                      agent {
                                        label "node1"
                                             }
                             steps {

                               withMaven(jdk: 'JAVA_HOME',maven: 'MAVEN_HOME') {
    // some block
    
                             bat 'mvn test -PRegression'
                                                                                }
    
                                    }

                    }
       
        
                 }
    }
        }
    post {
        always {
            junit '**/target/surefire-reports/TEST-*.xml'
             archiveArtifacts 'target/*.jar'
        }
    }
}
