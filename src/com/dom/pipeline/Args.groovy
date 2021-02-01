package com.dom.pipeline

class Args {
    private Script script

    Args(Script script) {
        this.script = script
    }

    public void passArgs(String arg) {
        echo "Pass Args test echo"
        script.sh """
            ls $arg .
        """
    }
}