pipeline {
    agent any
    
    tools {
    	maven 'Maven 3.5.4'
    	jdk 'jdk8'
    }
    
    stages {

        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
            }
        }
    
    	stage ('Build') {
            steps {
                sh 'mvn -Dmaven.test.skip=true compile' 
            }
    	}
    	stage ('Test') {
    		steps {
    			echo 'Testing...'
    			sh 'mvn test'
    		}
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
    		
    	}
    	stage ('Deploy local') {
    		steps {
    			echo 'Deploying...'
    			sh 'mvn install'
    		}
    	}
    	stage ('Generate docker image') {
    		steps {
    			echo 'Generating Docker Image...'
    			sh 'docker image build'
    		}
    	}
    }
}
