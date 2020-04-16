void dfs(int v, ArrayList<Integer>[] adj, int p, int[] par, int d, int[] dep) {
    dep[v] = d;
    par[v] = p;
    for (int i : adj[v]) if (i != p)
        dfs(i, adj, v, par, d + 1, dep);
}