#!groovy

import groovy.transform.Field

@Field String ENVIRONMENT
@Field String USER

def call(String branch) {
    properties([[$class: 'BuildDiscarderProperty', strategy: [$class: 'LogRotator', artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '500', numToKeepStr: '']]]);
    if (env.DEPLOY_ENVIRONMENT) {
        ENVIRONMENT = env.DEPLOY_ENVIRONMENT
    } else if (env.BUILD_ENVIRONMENT) {
        ENVIRONMENT = env.BUILD_ENVIRONMENT
    } else {
        ENVIRONMENT = ""
    }
    if (!branch?.trim()) {
        buildName "$BUILD_NUMBER-$GIT_COMMIT_SHORT"
    } else {
        buildName "$BUILD_NUMBER-$ENVIRONMENT-$branch-$GIT_COMMIT_SHORT"
    }

    if (currentBuild.getBuildCauses()[0].shortDescription == "Generic Cause") {
        USER = "WebHooker"
    } else {
        USER = env.BUILD_USER ? env.BUILD_USER : "Jenkins"
    }

    wrap([$class: 'BuildUser']){
        buildDescription "Executed @ ${NODE_NAME}. Build started by ${USER}"
    }
}
