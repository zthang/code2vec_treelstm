private int build(int node, int i, int j) {
    if (i == j) {
        int x = a[i] - 'a';
        return seg[node] = (1 << x);
    }
    int first = build(node * 2, i, (i + j) / 2);
    int second = build(node * 2 + 1, (i + j) / 2 + 1, j);
    return seg[node] = combine(first, second);
}