public void dfs(int node) {
    if (visited[node]) {
        return;
    }
    visited[node] = true;
    if (node == dest) {
        return;
    }
    for (int child : list[node]) {
        if (!visited[child]) {
            dfs(child);
        }
    }
}