pipeline {
    agent none
    stages {
        stage('Build') { 
            agent {
                    docker {
                          image 'maven:3-alpine' 
                          args '-v /root/.m2:/root/.m2' 
                    }
                }
            steps {
                sh 'mvn -B -DskipTests clean package' 
            }
        }

        stage('Test'){
            agent {
                    docker {
                          image 'maven:3-alpine' 
                          args '-v /root/.m2:/root/.m2' 
                    }
                }        
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Build Image'){
            agent { dockerfile { additionalBuildArgs '--tag bubooal/helloworldspringboot'}}
            steps {
                sh 'echo Image Build complete'
            }
        }

        stage('Push Image'){
            agent { 
                docker{
                    image 'docker'
                }
            }
            steps {
                sh 'docker login -u bubooal -p Filiberto123'
                sh 'docker push bubooal/helloworldspringboot'
            }
        }

        stage('Deploy Image'){
            agent { 
                docker{
                    image 'docker'
                }
            }
            steps {
                sh 'docker run -p 8081:8081 -d bubooal/helloworldspringboot'
            }
        }
    }
}
