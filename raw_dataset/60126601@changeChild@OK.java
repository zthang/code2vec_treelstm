public void changeChild(LCTNode y, LCTNode x) {
    if (left == y) {
        setLeft(x);
    } else {
        setRight(x);
    }
}