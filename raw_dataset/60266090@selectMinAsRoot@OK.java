/**
 * Make the node with the minimum key as the root of tree
 */
public static Splay selectMinAsRoot(Splay root) {
    if (root == NIL) {
        return root;
    }
    root.pushDown();
    while (root.left != NIL) {
        root = root.left;
        root.pushDown();
    }
    splay(root);
    return root;
}