@Library('my-library')_
pipeline {
    agent any

    environment {
        IMAGE_NAME = "vamsi011/java-app"
        TAG        = "${BUILD_NUMBER}"
        FULL_IMAGE = "${IMAGE_NAME}:${TAG}"
    }

    stages {

        stage('Docker build') {
            steps {
                script {
                    dockerUtil.dockerImageBuild(env.FULL_IMAGE)
                }
            }
        }

        stage('Deploy container') {
            steps {
                script {
                    dockerUtil.deployContainer(env.FULL_IMAGE, "8084:8081")
                }
            }
        }
    }
}



