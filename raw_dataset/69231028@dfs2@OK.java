static void dfs2(int v) {
    if (v == a)
        return;
    bs[v] = true;
    for (int u : adj[v]) {
        if (!bs[u])
            dfs2(u);
    }
}