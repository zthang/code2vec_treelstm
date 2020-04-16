private static void DFS(int u) {
    vis[u] = 1;
    for (int v : edge[u]) {
        if (vis[v] == 1)
            continue;
        parent[v] = u;
        height[v] = height[u] + 1;
        DFS(v);
    }
}