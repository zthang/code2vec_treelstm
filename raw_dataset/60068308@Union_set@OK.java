public static void Union_set(int u, int v) {
    if (u == v) {
        return;
    }
    if (size[u] > size[v]) {
        parent[v] = u;
        size[u] += size[v];
    } else if (size[u] <= size[v]) {
        parent[u] = v;
        size[v] += size[u];
    }
}