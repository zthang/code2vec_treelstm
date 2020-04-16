private long build(int node, int i, int j) {
    if (i == j)
        return seg[node] = a[i];
    long first = build(node * 2, i, (i + j) / 2);
    long second = build(node * 2 + 1, (i + j) / 2 + 1, j);
    return seg[node] = combine(first, second);
}