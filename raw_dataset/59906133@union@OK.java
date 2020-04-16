void union(int u, int v, int w) {
    int x = root(u), y = root(v);
    if (sz[x] > sz[y]) {
        int tmp = x;
        x = y;
        y = tmp;
    }
    ans[w] += (sz[x] * 1L * sz[y]);
    sz[y] += sz[x];
    F[x] = y;
}