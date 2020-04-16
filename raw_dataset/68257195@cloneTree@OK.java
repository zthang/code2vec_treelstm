public static Splay cloneTree(Splay splay) {
    if (splay == NIL) {
        return NIL;
    }
    splay = splay.clone();
    splay.left = cloneTree(splay.left);
    splay.right = cloneTree(splay.right);
    return splay;
}