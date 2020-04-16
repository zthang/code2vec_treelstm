private long query(int node, int i, int j, int l, int r) {
    if (l <= i && j <= r)
        return seg[node];
    if (j < l || i > r)
        return DEFAULT_VALUE;
    int m = (i + j) / 2;
    long first = query(node * 2, i, m, l, r);
    long second = query(node * 2 + 1, m + 1, j, l, r);
    return combine(first, second);
}