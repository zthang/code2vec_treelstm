static void dfs(int v, int p, int l) {
    sz[v]++;
    par[v] = p;
    lev[v] = l;
    for (int e : adj[v]) {
        dfs(e, v, l + 1);
        sz[v] += sz[e];
    }
    if (c[v] >= sz[v]) {
        invalid = true;
    }
}