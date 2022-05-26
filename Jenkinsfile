pipeline {
    agent none

    stages {
        stage('Build') {
            steps {
                echo 'Build App'
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
