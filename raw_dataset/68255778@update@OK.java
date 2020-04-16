public static Node update(Node a) {
    if (a == null)
        return null;
    a.count = 1;
    if (a.left != null)
        a.count += a.left.count;
    if (a.right != null)
        a.count += a.right.count;
    // TODO
    return a;
}