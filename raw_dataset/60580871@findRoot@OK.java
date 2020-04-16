public int findRoot(int v) {
    if (parent[v] == v)
        return v;
    return findRoot(parent[v]);
}