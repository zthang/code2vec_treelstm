private long update(int node, int i, int j, int k, long value) {
    if (k < i || k > j)
        return seg[node];
    if (i == j && j == k) {
        a[k] = value;
        seg[node] = value;
        return value;
    }
    int m = (i + j) / 2;
    long first = update(node * 2, i, m, k, value);
    long second = update(node * 2 + 1, m + 1, j, k, value);
    return seg[node] = combine(first, second);
}