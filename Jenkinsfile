#!groovy
pipeline{
    agent any
    stages{
    stage "Code Checkout & Build"{
      steps{
        checkout scm
        sh 'mvn clean package'
    }
      }
    } 
}

