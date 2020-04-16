private void combine(int node, int lo, int hi) {
    if (lo >= hi)
        return;
    tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
}