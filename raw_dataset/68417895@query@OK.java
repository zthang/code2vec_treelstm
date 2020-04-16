// O(log n)
int query(// O(log n)
int node, // O(log n)
int b, // O(log n)
int e, // O(log n)
int i, // O(log n)
int j) {
    if (i > e || j < b)
        return 0;
    if (b >= i && e <= j)
        return sTree[node];
    int mid = b + e >> 1;
    propagate(node, b, mid, e);
    int q1 = query(node << 1, b, mid, i, j);
    int q2 = query(node << 1 | 1, mid + 1, e, i, j);
    return q1 + q2;
}