long sum(int i) {
    long v = 0;
    while (i > 0) {
        v = v + tree[i];
        i -= i & (-i);
    }
    return v;
}