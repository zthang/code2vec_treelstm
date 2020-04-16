public static void cut(DynamicMST.LCTNode y, DynamicMST.LCTNode x) {
    makeRoot(y);
    access(x);
    splay(y);
    y.right.treeFather = NIL;
    y.right.father = NIL;
    y.setRight(NIL);
    y.pushUp();
}