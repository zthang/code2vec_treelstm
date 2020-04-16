private static int height(Node a) {
    if (a == null)
        return 0;
    int h = 1;
    if (a.left != null)
        h = Math.max(h, height(a.left) + 1);
    if (a.right != null)
        h = Math.max(h, height(a.right) + 1);
    return h;
}