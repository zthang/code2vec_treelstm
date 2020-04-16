static void dfs(int node, int par) {
    if (visited[node])
        return;
    visited[node] = true;
    for (int adj : adjList[node]) {
        if (adj != par) {
            dfs(adj, node);
        }
    }
}