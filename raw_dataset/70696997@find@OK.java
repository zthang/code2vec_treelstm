static int find(int v) {
    if (parent[v] == v)
        return v;
    parent[v] = find(parent[v]);
    return parent[v];
}