pipeline {
  agent {
    node {
      label 'Master'
    }

  }
  stages {
    stage('Build') {
      steps {
        git(credentialsId: '2745393e-0cb2-4949-b21e-1b1983873ade', url: 'https://github.com/jyotsnajadaun/CICDDemo.git', branch: 'develop')
      }
    }
stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv(credentialsId: 'NewToken',installationName:'Sonarqube'){
                    withMaven(jdk: 'JAVA_HOME',maven: 'MAVEN_HOME') {
                        bat 'mvn clean package sonar:sonar'
                    }
                
                }
            }
        }
    stage('Test') {
      parallel {
        stage('Smoke Test') {
          steps {
            withMaven(jdk: 'JAVA_HOME', maven: 'MAVEN_HOME') {
              bat 'mvn test -PSmoke'
            }

          }
        }

        stage('Regression Test') {
          agent {
            label 'node1'
          }
          steps {
            withMaven(jdk: 'JAVA_HOME', maven: 'MAVEN_HOME') {
              bat 'mvn test -PRegression'
            }

          }
        }

      }
    }
stage('Quality Gate') {
            steps {
                timeout(time: 1, unit: 'MINUTES') {
                waitForQualityGate abortPipeline: true
              }
            }
        }
    stage('Result') {
      steps {
        junit '**/target/surefire-reports/TEST-*.xml'
        archiveArtifacts 'target/*.jar'
      }
    }

  }
  post {
  //  always {
  //    junit '**/target/surefire-reports/TEST-*.xml'
     // archiveArtifacts 'target/*.jar'
   // }
     success {
          emailext attachLog: true, body: 'Please see the jenkins logs', subject: 'Jenkins Email Test', to: 'jyotsnajadaun8@gmail.com'
              }
  }
}
