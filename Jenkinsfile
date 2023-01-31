pipeline {

    agent any
    stages {

        stage('Checkout Codebase'){
            steps{

                 git  credentialsId: 'github', url: 'https://github.com/sebuxo/JenkinsBowling'
            }
        }

        stage('Build'){
            steps{

                sh 'cd src ; javac -cp "../lib/junit-4.13.1.jar" BowlingTest.java BowlingGame.java'
            }
        }

          stage('Test'){
                    steps{

                  script {
                    try{
                   sh 'cd src/ ; java -jar ../lib/junit-platform-console-standalone-1.7.0-all.jar -cp "." --select-class BowlingTest --reports-dir="reports"'
                   junit allowEmptyResults: true, testResults: '**/test-results/*.xml'
                   sh 'git checkout master'
                   sh 'git merge origin/dev'

                    }catch(Exception e){

                    throw e
                  }

          }
    }
}
}
}