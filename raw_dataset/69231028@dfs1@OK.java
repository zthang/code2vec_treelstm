static void dfs1(int v) {
    if (v == b)
        return;
    as[v] = true;
    for (int u : adj[v]) {
        if (!as[u])
            dfs1(u);
    }
}