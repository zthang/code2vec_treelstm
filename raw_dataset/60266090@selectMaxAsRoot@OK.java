/**
 * Make the node with the maximum key as the root of tree
 */
public static Splay selectMaxAsRoot(Splay root) {
    if (root == NIL) {
        return root;
    }
    root.pushDown();
    while (root.right != NIL) {
        root = root.right;
        root.pushDown();
    }
    splay(root);
    return root;
}