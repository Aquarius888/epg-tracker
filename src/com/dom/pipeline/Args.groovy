package com.dom.pipeline

class Args {
    private Script script

    Args(Script script) {
        this.script = script
    }

    public String passArgs(String arg) {
        return script.sh """
            ls $arg .
        """
    }
}