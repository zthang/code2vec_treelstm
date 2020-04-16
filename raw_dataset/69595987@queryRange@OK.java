long queryRange(int node, int start, int end, int l, int r) {
    if (start > end || start > r || end < l)
        // Out of range
        return 0;
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
    if (// Current segment is totally within range [l, r]
    start >= l && end <= r)
        return tree[node];
    int mid = (start + end) / 2;
    // Query left child
    long p1 = queryRange(node * 2, start, mid, l, r);
    // Query right child
    long p2 = queryRange(node * 2 + 1, mid + 1, end, l, r);
    return max(p1, p2);
}