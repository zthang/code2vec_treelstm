void dfs(int v, int p, int d) {
    sz[v] = 1;
    dep[v] = d;
    for (int i : adj[v]) {
        if (i == p)
            continue;
        dfs(i, v, d + 1);
        sz[v] += sz[i];
    }
}