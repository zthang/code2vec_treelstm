public static void Union_set(int u, int v) {
    u = find_set(u);
    v = find_set(v);
    if (u == v) {
        return;
    }
    if (size[v] > size[u]) {
        parent[u] = v;
        size[v] += size[u];
    } else {
        parent[v] = u;
        size[u] += size[v];
    }
}