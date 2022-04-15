def call() {
  pipeline {
    agent any

    stages {
        stage('Build') {
            when {
                expression {
                env.BRANCH_NAME == 'development'
                }
            }
          steps {
                echo 'Building..'
                sh './gradlew --version'
                sh './gradlew build --no-daemon'
            }
        }
    }
    post {
        always {
            echo 'Archive..'
            archiveArtifacts artifacts: 'dist/trainSchedule.zip'
        }
    }
}
}
