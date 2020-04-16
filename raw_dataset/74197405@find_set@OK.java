public static int find_set(int u) {
    if (u == parent[u]) {
        return u;
    }
    return parent[u] = find_set(parent[u]);
}