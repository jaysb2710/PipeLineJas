// class http://javadoc.jenkins-ci.org/hudson/model/Cause.UpstreamCause.html#getUpstreamProject--

def isJobStartedByTimer() {
    def startedByTimer = false
    try {
        def buildCauses = currentBuild.rawBuild.getCauses()
        for ( buildCause in buildCauses ) {
            if (buildCause != null && buildCause.properties) {
                def causeDescription = buildCause.getUpstreamProject()
                echo "upstreamProject: ${causeDescription}"
            }
            else
            {
                echo "build cause : ${buildCause}"
            }
        }
    } catch(theError) {
        echo "Error getting build cause ${theError}"
        throw theError
    }
 
    return startedByTimer
}

def getCauser() {
    def build = currentBuild.rawBuild
    def upstreamCause
    while(upstreamCause = build.getCause(hudson.model.Cause$UpstreamCause)) {
        build = upstreamCause.upstreamRun
    }
    return build.getCause(hudson.model.Cause$UserIdCause).userId
}

def getJobName(){
    def buildResult=manager.getResult()
    def jobName=manager.getEnvVariable("JOB_NAME")
    return buildResult+jobName
}

def getPreBuild(){
    def lastBuild = currentBuild.rawBuild.getPreviousBuild()
    if( lastBuild ){
        return "the previous build is ${lastBuild.getId()} "
    }
    else
    {
        return "Previous build not found!"
    }
}

def printRawBuild(){
    println "CAUSE ${currentBuild.rawBuild.getCause(hudson.model.Cause$UserIdCause)}"
}

def printCauseInfo(){
    def upstreamCause = currentBuild.rawBuild.getCause(hudson.model.Cause$UpstreamCause)
    if(upstreamCause)
    {
        // buildCause.getUpstreamProject(),getShortDescription()
        def projectName = 	upstreamCause.getUpstreamProject()
        echo " ${projectName} "
    }
}

return this;