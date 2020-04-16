public void pushDown() {
    if (reverse) {
        reverse = false;
        DynamicMST.LCTNode tmpNode = left;
        left = right;
        right = tmpNode;
        left.reverse();
        right.reverse();
    }
    left.treeFather = treeFather;
    right.treeFather = treeFather;
}