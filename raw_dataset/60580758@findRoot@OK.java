public int findRoot(int v) {
    if (parent[v] == v)
        return v;
    return parent[v] = findRoot(parent[v]);
}