private void dfs(int u) {
    if (visited[u])
        return;
    visited[u] = true;
    count++;
    for (int v : graph.get(u)) if (!visited[v])
        dfs(v);
}