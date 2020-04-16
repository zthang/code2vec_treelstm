void flip(int u) {
    for (int i = 0; i < u; i++) {
        deg[u] -= graph[u][i];
        deg[i] += graph[u][i];
        graph[u][i] = -graph[u][i];
    }
    for (int i = u + 1; i < n; i++) {
        deg[u] += graph[i][u];
        deg[i] -= graph[i][u];
        graph[i][u] = -graph[i][u];
    }
}