private static void DFS(int u) {
    tin[u] = timer++;
    for (int v : edge[u]) {
        if (v == parent[u])
            continue;
        parent[v] = u;
        depth[v] = depth[u] + 1;
        DFS(v);
    }
    tout[u] = timer++;
}