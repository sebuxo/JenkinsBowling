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
            sh 'git checkout origin/dev'
            sh 'cd src ; javac -cp "../lib/junit-4.13.1.jar" BowlingTest.java BowlingGame.java'
            }
        }

          stage('Test'){
                    steps{

                  script {
                    try{
                    sh 'git checkout origin/dev'
                   sh 'cd src/ ; java -jar ../lib/junit-platform-console-standalone-1.7.0-all.jar -cp "." --select-class BowlingTest --reports-dir="reports"'
                   junit allowEmptyResults: true, testResults: '**/test-results/*.xml'
                   sh 'git checkout master'
                   //sh 'git merge dev'
                    }catch(Exception e){
                   sh 'git checkout -B rejected/nobuild'
                   //sh 'git push origin -u rejected/nobuild'
                    throw e
                  }

          }
    }
}