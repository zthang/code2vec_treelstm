public static void zag(LCTNode x) {
    LCTNode y = x.father;
    LCTNode z = y.father;
    LCTNode b = x.left;
    y.setRight(b);
    x.setLeft(y);
    z.changeChild(y, x);
    y.pushUp();
}