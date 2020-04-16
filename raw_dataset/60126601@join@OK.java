public static void join(LCTNode y, LCTNode x) {
    makeRoot(x);
    x.treeFather = y;
}