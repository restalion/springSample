pipeline {
    agent any
    
    stages {
    	stage ('Build') {
    		steps {
    			echo 'Building...'
    			tools {
    			    maven 'Maven 3.5.4'
    			    jdk 'jdk8'
    			}

    		}
    	}
    	stage ('Test') {
    		steps {
    			echo 'Testing...'
    		}
    	}
    	stage ('Deploy') {
    		steps {
    			echo 'Deploying...'
    		}
    	}
    }
}
