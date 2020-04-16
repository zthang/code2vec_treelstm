public static Node build(int[] a, int l, int r) {
    if (l >= r)
        return null;
    int h = l + r >> 1;
    Node root = new Node(a[h]);
    Node L = build(a, l, h);
    root.left = L;
    if (L != null)
        L.parent = root;
    Node R = build(a, h + 1, r);
    root.right = R;
    if (R != null)
        R.parent = root;
    return update(root);
}