import com.dom.pipeline.Args

def call(String arg="") {
    Args args = new Args(this)
    echo "Pass Args test echo"
    args.passArgs(arg)
}