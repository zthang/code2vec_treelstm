void update_range(int node, int b, int e, int i, int j, long val) {
    if (i > e || j < b)
        return;
    if (b >= i && e <= j) {
        sTree[node] += (e - b + 1) * val;
        lazy[node] += val;
    } else {
        int mid = b + e >> 1;
        propagate(node, b, mid, e);
        update_range(node << 1, b, mid, i, j, val);
        update_range(node << 1 | 1, mid + 1, e, i, j, val);
        sTree[node] = sTree[node << 1] + sTree[node << 1 | 1];
    }
}