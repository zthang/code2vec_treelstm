public static void zig(DynamicMST.LCTNode x) {
    DynamicMST.LCTNode y = x.father;
    DynamicMST.LCTNode z = y.father;
    DynamicMST.LCTNode b = x.right;
    y.setLeft(b);
    x.setRight(y);
    z.changeChild(y, x);
    y.pushUp();
}