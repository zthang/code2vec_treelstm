/**
 * delete root of tree, then merge remain nodes into a new tree, and return the new root
 */
public static Splay deleteRoot(Splay root) {
    root.pushDown();
    Splay left = splitLeft(root);
    Splay right = splitRight(root);
    return merge(left, right);
}