public void changeChild(DynamicMST.LCTNode y, DynamicMST.LCTNode x) {
    if (left == y) {
        setLeft(x);
    } else {
        setRight(x);
    }
}