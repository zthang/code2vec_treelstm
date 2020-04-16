public int findParent(int u) {
    return parent[u] == u ? u : (parent[u] = findParent(parent[u]));
}