public static Splay splitRight(Splay root) {
    root.pushDown();
    Splay right = root.right;
    right.father = NIL;
    root.setRight(NIL);
    root.pushUp();
    return right;
}