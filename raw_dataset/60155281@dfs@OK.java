static void dfs(ArrayList<Integer>[] adj, int[] deg, int u) {
    for (int v : adj[u]) {
        deg[v]--;
        if (deg[v] == 0)
            dfs(adj, deg, v);
    }
}