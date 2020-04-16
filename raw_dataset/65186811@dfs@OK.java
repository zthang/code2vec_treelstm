public void dfs(int node, int root) {
    visited[node] = true;
    union(node, root);
    max = Math.max(max, node);
    for (int nd : G[node]) {
        if (!visited[nd]) {
            dfs(nd, root);
        }
    }
}