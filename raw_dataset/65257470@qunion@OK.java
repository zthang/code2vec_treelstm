static void qunion(int p, int q) {
    int i = root(p);
    int j = root(q);
    if (i == j)
        return;
    if (sz[i] < sz[j]) {
        id[i] = j;
        sz[j] += sz[i];
        mx[j] = Math.max(mx[i], mx[j]);
        mn[j] = Math.min(mn[i], mn[j]);
    } else {
        id[j] = i;
        sz[i] += sz[j];
        mx[i] = Math.max(mx[i], mx[j]);
        mn[i] = Math.min(mn[i], mn[j]);
    }
}