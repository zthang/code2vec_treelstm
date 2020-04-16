private int update(int node, int i, int j, int k, char value) {
    if (k < i || k > j)
        return seg[node];
    if (i == j && j == k) {
        a[k] = value;
        int x = a[i] - 'a';
        return seg[node] = (1 << x);
    }
    int m = (i + j) / 2;
    int first = update(node * 2, i, m, k, value);
    int second = update(node * 2 + 1, m + 1, j, k, value);
    return seg[node] = combine(first, second);
}