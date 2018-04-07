/* -----------------------------------------------------------
Description: The entry of OOSS pipeline
Author: William Wang
Date: 2018-04-03
------------------------------------------------------------*/
node {
    def helper = load("${WORKSPACE}@script/pipeline-helper.groovy")
    def notification = load("${WORKSPACE}@script/notification.groovy")
    def checker = load("${WORKSPACE}@script/checker.groovy")
    def checkerInstance = checker.getInstance()
    stage('Operate') {
        checkerInstance.Operate()
    }
    stage('Optimize') {
        checkerInstance.Operate()
    }
    stage('Secure') {
        checkerInstance.Secure()
    }
    stage('Scale') {
       checkerInstance.Scale()
    }
    stage('Summary') {
        checkerInstance.Summary()
        notification.notifySlack "summary for ooss check xxxxxx"
    }
}