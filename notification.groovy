import groovy.json.JsonOutput

// Send notofication message to slack
def notifySlack(text) {
    def slackURL = 'https://hooks.slack.com/services/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'
    def payload = JsonOutput.toJson([text      : text,
                                     username  : "Jenkins",
                                     icon_emoji: ":jenkins:"])
    sh "curl -X POST --data-urlencode \'payload=${payload}\' ${slackURL}"
}

return this;
