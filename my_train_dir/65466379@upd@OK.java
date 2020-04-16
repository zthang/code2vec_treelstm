private static void upd(Tree t, int ind, int v) {
    if (t.st == t.en) {
        t.val = v;
        return;
    }
    int mid = (t.st + t.en) / 2;
    t.val = Math.max(t.val, v);
    if (ind <= mid) {
        if (t.left == null) {
            t.left = new Tree(t.st, mid, v);
        }
        upd(t.left, ind, v);
    } else {
        if (t.right == null) {
            t.right = new Tree(mid + 1, t.en, v);
        }
        upd(t.right, ind, v);
    }
}