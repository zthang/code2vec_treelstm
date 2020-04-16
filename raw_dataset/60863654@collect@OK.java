private int collect(Node cur, int p) {
    gctCollect++;
    if (cur == null || cur.desaux == 0)
        return p;
    if (cur.desaux - (cur.left != null ? cur.left.desaux : 0) - (cur.right != null ? cur.right.desaux : 0) > 0) {
        collected[p++] = cur.from;
    }
    p = collect(cur.left, p);
    p = collect(cur.right, p);
    return p;
}