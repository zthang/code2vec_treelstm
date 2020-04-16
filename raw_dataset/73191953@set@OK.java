private static void set(int u, int[] res, boolean[] vis) {
    vis[u] = true;
    for (int i = 0; i < G[u].size(); i++) {
        int v = G[u].get(i);
        if (!vis[v]) {
            res[v] = Math.max(res[v], res[u] - Math.max(0, res[v]) + res[v]);
            set(v, res, vis);
        }
    }
}