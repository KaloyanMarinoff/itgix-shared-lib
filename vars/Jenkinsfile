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
