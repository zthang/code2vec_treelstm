private void pushDown(int node, int lo, int hi) {
    if (lo >= hi || lazy[node] == -1)
        return;
    lazy[node * 2] = lazy[node];
    lazy[node * 2 + 1] = lazy[node];
    tree[node * 2] = lazy[node];
    tree[node * 2 + 1] = lazy[node];
    /* clear lazy of node */
    lazy[node] = -1;
}