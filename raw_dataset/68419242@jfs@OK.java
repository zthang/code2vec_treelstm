static void jfs(int v, int p) {
    size[v] = 1;
    for (int to : g[v]) if (to != p) {
        jfs(to, v);
        size[v] += size[to];
    }
}