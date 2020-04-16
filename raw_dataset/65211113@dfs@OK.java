static void dfs(int node, int par) {
    if (visited[node])
        return;
    visited[node] = true;
    min = Math.min(min, node);
    max = Math.max(max, node);
    for (int adj : adjList[node]) {
        if (adj != par) {
            dfs(adj, node);
        }
    }
}