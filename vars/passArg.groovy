import com.dom.pipeline.Args

def call(String arg="") {
    Args args = new Args(this)
    echo "Pass Args test echo"
    def output = args.passArgs(arg)
    sh "cat $output | grep jenkins"
}