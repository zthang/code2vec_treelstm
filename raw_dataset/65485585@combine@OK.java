static void combine(int p, int q) {
    int i = root(p);
    int j = root(q);
    if (i == j) {
        return;
    }
    fa[i] = j;
    if (sz[i] < sz[j]) {
        fa[i] = j;
        sz[j] += sz[i];
    } else {
        fa[j] = i;
        sz[i] += sz[j];
    }
    groups--;
}