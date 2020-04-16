/**
 * detach the left subtree from root and return the root of left subtree
 */
public static Splay splitLeft(Splay root) {
    root.pushDown();
    Splay left = root.left;
    left.father = NIL;
    root.setLeft(NIL);
    root.pushUp();
    return left;
}