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
        sh './gradlew test'
      }
    }
  }
}