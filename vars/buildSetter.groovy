#!groovy

import groovy.transform.Field

@Field String ENVIRONMENT
@Field String USER

def call(String branch) {
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
    // USER = env.BUILD_USER ?: "Jenkins"

    try:
        USER = "${BUILD_USER}"
    catch Exception:
        USER = "Jenkins"
    wrap([$class: 'BuildUser']){
            // USER = "${BUILD_USER}" ? "${BUILD_USER}" : "Jenkins"
            buildDescription "Executed @ ${NODE_NAME}. Build started by ${BUILD_USER}"
        }
}