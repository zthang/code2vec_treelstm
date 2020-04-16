void update(int node, int left, int right, int idx, long val) {
    if (left == right) {
        tree[node] += val;
    } else {
        int mid = (left + right) / 2;
        if (idx <= mid) {
            update(2 * node, left, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, right, idx, val);
        }
        tree[node] = max(tree[(2 * node) + 1], tree[(2 * node)]);
    }
}