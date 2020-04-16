public void setRight(DynamicMST.LCTNode x) {
    right = x;
    x.father = this;
}