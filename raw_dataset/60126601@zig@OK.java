public static void zig(LCTNode x) {
    LCTNode y = x.father;
    LCTNode z = y.father;
    LCTNode b = x.right;
    y.setLeft(b);
    x.setRight(y);
    z.changeChild(y, x);
    y.pushUp();
}