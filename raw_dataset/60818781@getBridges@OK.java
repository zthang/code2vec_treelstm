static void getBridges(int u) {
    visited[u] = true;
    disc[u] = low[u] = time++;
    for (int v : graph[u]) {
        if (!visited[v]) {
            parent[v] = u;
            getBridges(v);
            low[u] = Math.min(low[u], low[v]);
            if (low[v] > disc[u]) {
                not[v].add(u);
                not[u].add(v);
            }
        } else if (v != parent[u]) {
            low[u] = Math.min(low[u], disc[v]);
        }
    }
}