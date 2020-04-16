public static int getParent(int u) {
    if (parent[u] == u)
        return u;
    return parent[u] = getParent(parent[u]);
}