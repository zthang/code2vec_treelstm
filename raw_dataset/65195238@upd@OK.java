private static void upd(Tree tr, int pos, int val) {
    tr.max = Math.max(tr.max, val);
    if (tr.st == tr.en) {
        return;
    }
    int mid = (tr.st + tr.en) / 2;
    if (pos <= mid) {
        if (tr.left == null) {
            tr.left = new Tree(tr.st, mid, 0);
        }
        upd(tr.left, pos, val);
    } else {
        if (tr.right == null) {
            tr.right = new Tree(mid + 1, tr.en, 0);
        }
        upd(tr.right, pos, val);
    }
}