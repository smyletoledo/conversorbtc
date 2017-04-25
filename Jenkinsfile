pipeline {
  agent {
    label {
      label 'TVO'
    }
    
  }
  stages {
    stage('inicializar') {
      steps {
        sh 'ls'
      }
    }
    stage('Buil') {
      steps {
        sh '''chmod 766 gradlew
./gradlew test'''
      }
    }
  }
}