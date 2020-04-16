public static Node insertb(Node root, Node x) {
    int ind = lowerBound(root, x.v);
    return insert(root, ind, x);
}