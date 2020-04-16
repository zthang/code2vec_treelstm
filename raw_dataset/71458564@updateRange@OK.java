void updateRange(int node, int start, int end, int l, int r, long val) {
    if (lazy[node] != 0) {
        // This node needs to be updated
        // Update it
        tree[node] = lazy[node];
        if (start != end) {
            // Mark child as lazy
            lazy[node * 2] = lazy[node];
            // Mark child as lazy
            lazy[node * 2 + 1] = lazy[node];
        }
        // Reset it
        lazy[node] = 0;
    }
    if (// Current segment is not within range [l, r]
    start > end || start > r || end < l)
        return;
    if (start >= l && end <= r) {
        // Segment is fully within range
        tree[node] = val;
        if (start != end) {
            // Not leaf node
            lazy[node * 2] = val;
            lazy[node * 2 + 1] = val;
        }
        return;
    }
    int mid = (start + end) / 2;
    // Updating left child
    updateRange(node * 2, start, mid, l, r, val);
    // Updating right child
    updateRange(node * 2 + 1, mid + 1, end, l, r, val);
    // Updating root with max value
    tree[node] = max(tree[node * 2], tree[node * 2 + 1]);
}