public static void makeRoot(LCTNode x) {
    access(x);
    splay(x);
    x.reverse();
}