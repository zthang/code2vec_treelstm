public void changeChild(Splay y, Splay x) {
    if (left == y) {
        setLeft(x);
    } else {
        setRight(x);
    }
}