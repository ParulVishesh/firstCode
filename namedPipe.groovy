#!groovy

env.GIT_URL = 'https://github.com/ParulVishesh/firstCode.git'

node(LABEL) {
    timestamps {
        stage('Checkout') {
                    // TODO: Use the git step when it has implemented specifying refspecs
                    // See https://jenkins.io/doc/pipeline/steps/workflow-scm-step/ for CloneOption
                    checkout([$class: 'GitSCM', branches: [[name: ROOT_BRANCH]], doGenerateSubmoduleConfigurations: false,
                            extensions: [[$class: 'CloneOption', timeout: 10, noTags: true, shallow: false]]
                                       +[[$class: 'LocalBranch', localBranch: '']]
                                       +[[$class: 'CleanBeforeCheckout', deleteUntrackedNestedRepositories: true]],
                            submoduleCfg: [], userRemoteConfigs: [[refspec: ROOT_REFSPEC, url: env.GIT_URL]]])
        }
        stage('print output'){
            sh'''
                pyhton example.py
            '''
    }
}









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
