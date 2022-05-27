pipeline {
  agent {
    node {
      label 'master'
    }

  }
  stages {
    stage('Build') {
      steps {
        git(credentialsId: '2745393e-0cb2-4949-b21e-1b1983873ade', url: 'https://github.com/jyotsnajadaun/CICDDemo.git', branch: 'develop')
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

    stage('Result') {
      steps {
        junit 'junit \'**/target/surefire-reports/TEST-*.xml\''
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