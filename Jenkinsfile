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
    stage('Build') {
      steps {
        sh 'gradle test'
      }
    }
  }
}