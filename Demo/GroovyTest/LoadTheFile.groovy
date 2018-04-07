node {
    // Load the file 'externalMethod.groovy' from the current directory, into a variable called "externalMethod".
    def externalMethod = load("../LoadGroovyFile@script/GroovyTest/externalMethod.groovy")
    def externalCall = load("../LoadGroovyFile@script/GroovyTest/externalCall.groovy")

    stage('External Call') {
    // Call the method we defined in externalMethod.
    externalMethod.lookAtThis("Steve")
    // Now load 'externalCall.groovy'.
    // We can just run it with "externalCall(...)" since it has a call method.
    externalCall("Steve")
    }
}