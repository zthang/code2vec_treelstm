static int findSet(int v) {
    // returns root(representative) of v
    if (parent[v] == v)
        return v;
    // path compression
    return parent[v] = findSet(parent[v]);
}