#!groovy
pipeline{
    agent any{
        checkout scm
        sh 'mvn clean package'
    }
    stages{
    stage "TEST"{
      steps{
        echo "Hi"
      }
    } 
    }
    
}
