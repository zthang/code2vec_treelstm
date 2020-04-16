private static int query(Tree t, int x, int y) {
    if (t.st == x && t.en == y) {
        return t.val;
    }
    int mid = (t.st + t.en) / 2;
    if (y <= mid) {
        return query(t.left, x, y);
    }
    if (x > mid) {
        return query(t.right, x, y);
    }
    return Math.max(query(t.left, x, mid), query(t.right, mid + 1, y));
}