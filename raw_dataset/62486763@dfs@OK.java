static void dfs(int v, int baap) {
    nodes.add(v);
    for (int e : adj[v]) {
        if (e != baap) {
            dfs(e, v);
        }
    }
}