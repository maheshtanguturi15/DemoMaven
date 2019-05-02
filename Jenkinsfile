#!Groovy

node()
{
    stage('Git Checkout')
    {
        // Git Checkout the demo maven application
        git credentialsId: 'GITCREDS', url: 'https://github.com/maheshtanguturi15/DemoMaven.git'
    }

    stage('Maven Build')
    {
        // Build the pom.xml with maven
        withMaven(maven: 'TestMaven')
        {
            sh "mvn clean install"
        }
    }
} 