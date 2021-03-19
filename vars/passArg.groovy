import com.dom.pipeline.Args

def call(String arg="") {
    Args args = new Args(this)
    // echo "Pass Args test echo"
    if (env.verbose) {
       echo "Verbose" 
    } else {
       echo "FALSE"
    }
    args.passArgs(arg)
}
