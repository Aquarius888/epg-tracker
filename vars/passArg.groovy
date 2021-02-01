import com.dom.pipeline.Args

def call(String arg=null) {
    Args args = new Args(this)
    if (arg == null) {
        args('.')
    } else {
        args(arg + ' .')}
}