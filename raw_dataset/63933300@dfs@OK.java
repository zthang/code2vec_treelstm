private void dfs(int u) {
    visited[u] = true;
    node[u] = 1;
    for (Edge v : graph.get(u)) {
        if (!visited[v.to]) {
            color[v.idx] = 1;
            dfs(v.to);
        } else if (node[v.to] == 1) {
            color[v.idx] = 2;
            cycle = true;
        } else if (node[v.to] == 2) {
            color[v.idx] = 1;
        }
    }
    node[u] = 2;
}