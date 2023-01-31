pipeline {

    agent any
    stages {

        stage('Checkout Codebase'){
            steps{

                 git credentialsId: 'github', url: 'https://github.com/sebuxo/Bowling'
            }
        }

        stage('Build'){
            steps{

                sh 'cd src ; dir'
            }
        }

          stage('Test'){
                    steps{

                  script {

                    try{
                   sh 'cd src/ ; java -jar ../lib/junit-platform-console-standalone-1.7.0-all.jar -cp "." --select-class BowlingTest --reports-dir="reports"'

                                        junit allowEmptyResults: true, testResults: '**/test-results/*.xml'
                   sh 'echo success'
                    }catch(Exception e){
                  sh 'echo "error is ${e}"'
                  }

          }
    }
}
}
}