static int find(int v) {
    if (parent[v] == v) {
        return v;
    }
    return parent[v] = find(parent[v]);
}