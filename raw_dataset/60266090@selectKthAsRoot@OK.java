public static Splay selectKthAsRoot(Splay root, int k) {
    if (root == NIL) {
        return NIL;
    }
    Splay trace = root;
    Splay father = NIL;
    while (trace != NIL) {
        father = trace;
        trace.pushDown();
        if (trace.left.size >= k) {
            trace = trace.left;
        } else {
            k -= trace.left.size + 1;
            if (k == 0) {
                break;
            } else {
                trace = trace.right;
            }
        }
    }
    splay(father);
    return father;
}