private int build(int node, int i, int j) {
    if (i == j) {
        return seg[node] = a[i];
    }
    int first = build(node * 2, i, (i + j) / 2);
    int second = build(node * 2 + 1, (i + j) / 2 + 1, j);
    return seg[node] = combine(first, second);
}