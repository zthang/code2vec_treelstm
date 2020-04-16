public void dfs(int node) {
    if (visited[node]) {
        return;
    }
    visited[node] = true;
    for (Integer nextnode : nodes.get(node).neighbors) {
        if (!visited[nextnode]) {
            dfs(nextnode);
        }
    }
}