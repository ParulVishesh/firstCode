pipeline {
    agent any
    stages {
        stage('Hello world') {
            steps {
                echo 'Hello World'
                echo 'This is my first program from GITHUB'
            }
        }
    }
}
