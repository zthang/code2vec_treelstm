public static LCTNode findRoot(LCTNode x) {
    x.pushDown();
    while (x.left != NIL) {
        x = x.left;
        x.pushDown();
    }
    splay(x);
    return x;
}