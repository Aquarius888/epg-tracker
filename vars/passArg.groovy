import com.dom.pipeline.Args

def call(String arg=".") {
    Args args = new Args(this)
    if (arg == ".") {
        args(${arg})
    } else {
        arg += ' .'
        args(${arg})
    }
        
}