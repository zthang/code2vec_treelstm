public static void makeRoot(DynamicMST.LCTNode x) {
    access(x);
    splay(x);
    x.reverse();
}