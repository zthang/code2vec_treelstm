void update(int i, long v) {
    while (i < tree.length) {
        tree[i] += v;
        i += i & (-i);
    }
}