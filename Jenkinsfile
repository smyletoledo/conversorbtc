pipeline {
  agent {
    label {
      label 'TVO'
    }
    
  }
  stages {
    stage('Unit Test') {
      steps {
        sh '''chmod 766 gradlew
./gradlew test'''
      }
    }
  }
}