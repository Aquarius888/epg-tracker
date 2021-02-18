package com.dom.pipeline

class Args {
    private Script script

    Args(Script script) {
        this.script = script
    }

    public String passArgs(String arg) {
        def t = script.sh (script:"""
            ls $arg .
        """, returnStdout: true)
        return t
    }
}