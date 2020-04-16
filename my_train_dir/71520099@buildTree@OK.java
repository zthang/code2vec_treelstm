private void buildTree(int node, int lo, int hi) {
    if (lo == hi) {
        tree[node] = lo;
        return;
    }
    int m = (lo + hi) / 2;
    buildTree(node * 2, lo, m);
    buildTree(node * 2 + 1, m + 1, hi);
    pushUp(node, lo, hi);
}