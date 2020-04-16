void dfs(int node) {
    visited[node] = true;
    for (int k : g[node]) {
        if (!visited[k])
            dfs(k);
    }
}