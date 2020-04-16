public static void zag(DynamicMST.LCTNode x) {
    DynamicMST.LCTNode y = x.father;
    DynamicMST.LCTNode z = y.father;
    DynamicMST.LCTNode b = x.left;
    y.setRight(b);
    x.setLeft(y);
    z.changeChild(y, x);
    y.pushUp();
}