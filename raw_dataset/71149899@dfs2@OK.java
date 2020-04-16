static void dfs2(int v, int val, int par, int no) {
    res[v] = pat[no][val];
    for (int u : adj[v]) {
        if (u != par) {
            dfs2(u, (val + 1) % 3, v, no);
        }
    }
}