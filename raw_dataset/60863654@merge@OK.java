private static Node merge(Node a, Node b) {
    gctMerge++;
    if (b == null)
        return a;
    if (a == null)
        return b;
    if (a.priority > b.priority) {
        if (a.right != null)
            a.right.parent = null;
        b.parent = null;
        a.right = merge(a.right, b);
        a.right.parent = a;
        return update(a);
    } else {
        a.parent = null;
        if (b.left != null)
            b.left.parent = null;
        b.left = merge(a, b.left);
        b.left.parent = b;
        return update(b);
    }
}