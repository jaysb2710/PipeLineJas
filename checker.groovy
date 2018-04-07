def getUpStreamProject(){
    def projectName;
    def upstreamCause = currentBuild.rawBuild.getCause(hudson.model.Cause$UpstreamCause);
    if(upstreamCause)
    {
        projectName = 	upstreamCause.getUpstreamProject();
    }
    return projectName;
}

def getInstance(){
    def checkName = "ooss-default";
    def upStreamProject = getUpStreamProject();
    switch(upStreamProject) {
        case "Platform DXC/config-mgmt":
            checkName="config-mgmt";
        break      
    }
    return load("${WORKSPACE}@script/${checkName}.groovy")
}
return this;