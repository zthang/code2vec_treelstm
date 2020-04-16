void go(int rt) {
    for (int u : g[rt]) {
        go(u);
        sz[rt] += sz[u];
    }
    sz[rt]++;
}