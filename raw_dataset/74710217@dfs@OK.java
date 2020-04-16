/*
    recursion for calculating 2^jth ancestor of node i:
    up[i][j] = parent[i] if j = 0 and
    up[i][j] = up[up[i][j – 1]][j – 1] if j > 0.
    */
static void dfs(int v, int par) {
    tin[v] = ++timer;
    up[v][0] = par;
    for (int i = 1; i < l; i++) {
        up[v][i] = up[up[v][i - 1]][i - 1];
    }
    for (int u : adj[v]) {
        if (u == par)
            continue;
        dfs(u, v);
    }
    tout[v] = ++timer;
}