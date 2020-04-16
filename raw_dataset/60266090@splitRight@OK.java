/**
 * detach the right subtree from root and return the root of right subtree
 */
public static Splay splitRight(Splay root) {
    root.pushDown();
    Splay right = root.right;
    right.father = NIL;
    root.setRight(NIL);
    root.pushUp();
    return right;
}