public static void Union_set(int u, int v) {
    u = find_set(u);
    v = find_set(v);
    if (u == v) {
        return;
    } else {
        if (size[u] > size[v]) {
            parent[v] = u;
            size[u] += size[v];
        } else {
            parent[u] = v;
            size[v] += size[u];
        }
    }
}