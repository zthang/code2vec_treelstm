public static int find_set(int u) {
    if (parent[u] == u) {
        return u;
    }
    return parent[u] = find_set(parent[u]);
}