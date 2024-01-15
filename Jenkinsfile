pipeline {
    agent any

    environment {
        MAVEN_HOME = 'C:\\apache-maven-3.9.6'
        PATH = 'MAVEN_HOME\\bin;%PATH%'
    }

    tools {
        // Define the JDK version
        jdk 'your-jdk-version'
        // Define the Maven tool
        maven 'your-maven-tool'
    }

    stages {
        stage('Checkout') {
            steps {
                git checkout main
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

//         stage('Test') {
//             steps {
//                 // Run tests
//                 sh 'mvn test'
//             }
//         }

//         stage('Deploy') {
//             steps {
//                 // Additional deployment steps, if needed
//             }
//         }
    }

    post {
        success {
            // Archive artifacts or perform other post-build actions
            archiveArtifacts 'target/*.jar'
        }
    }
}