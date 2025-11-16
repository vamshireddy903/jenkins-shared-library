pipeline {
    agent any
    
    environment {
        IMAGE_NAME = "vamsi011/java-app"
        TAG = "${BUILD_NUMBER}" 
        FULL_IMAGE = "${IMAGE_NAME}:${TAG}"
    }

    stages {
        stage('Docker build') {
            steps {
                sh 'docker build -t ${FULL_IMAGE} .'
            }
        }
         stage('Deploy container') {
            steps {
                sh 'docker run -d -p 8082:8081 ${FULL_IMAGE}'
            }
        }
    }
}
