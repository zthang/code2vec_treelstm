static void dfs(int node, int par, int dep) {
    depth[node] = dep;
    parent[node] = par;
    tin[node] = tym++;
    for (int i : adj[node]) {
        if (i != par) {
            dfs(i, node, dep + 1);
        }
    }
    tout[node] = tym++;
}