public static void join(DynamicMST.LCTNode y, DynamicMST.LCTNode x) {
    makeRoot(x);
    x.treeFather = y;
}