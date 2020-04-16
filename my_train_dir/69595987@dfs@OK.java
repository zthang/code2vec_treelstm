private static void dfs(int u, List<Integer>[] adj, boolean[] visited) {
    c++;
    visited[u] = true;
    for (int v : adj[u]) {
        if (!visited[v]) {
            dfs(v, adj, visited);
        }
    }
}