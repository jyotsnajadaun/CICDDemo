pipeline {
    agent none

 tools{
maven "MAVEN_HOME"

}

    stages {
        stage('Build') {
            steps {

             git "https://github.com/jyotsnajadaun/CICDDemo.git"
             bat "mvn -Dmaven.test.failure.ignore=true clean package"
               // echo 'Build App'
            }
        }
        
        stage('Test') {
            parallel {
                stage('Smoke Test') {
                    agent {
                        label "node1"
                    }
                    steps {
                        echo 'Smoke Test App'
                    }
                   
                }
                stage('Regression Test') {
                    agent none
                    steps {
                         echo 'Regression Test App'
                    }
                   
                }
            }
        }
    }
}
