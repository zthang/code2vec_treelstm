private static int find(int u, int[] res, boolean[] vis) {
    vis[u] = true;
    int max = 0;
    for (int i = 0; i < G[u].size(); i++) {
        int v = G[u].get(i);
        if (!vis[v])
            max += Math.max(0, find(v, res, vis));
    }
    res[u] = a[u] + max;
    return res[u];
}