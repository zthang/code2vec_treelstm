private static void dfs(int node, int parent, int d) {
    par[node] = parent;
    dep[node] = d;
    tin[node] = T++;
    for (int child : graph[node]) {
        if (child == parent)
            continue;
        dfs(child, node, d + 1);
    }
    tout[node] = T++;
}