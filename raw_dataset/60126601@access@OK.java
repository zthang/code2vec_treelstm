public static void access(LCTNode x) {
    LCTNode last = NIL;
    while (x != NIL) {
        splay(x);
        x.right.father = NIL;
        x.right.treeFather = x;
        x.setRight(last);
        x.pushUp();
        last = x;
        x = x.treeFather;
    }
}