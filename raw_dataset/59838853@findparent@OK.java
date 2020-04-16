private static int findparent(int u) {
    if (parent[u] != u)
        parent[u] = findparent(parent[u]);
    return parent[u];
}