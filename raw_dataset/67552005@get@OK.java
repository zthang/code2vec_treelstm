int get(int v) {
    if (parent[v] != v)
        return parent[v] = get(parent[v]);
    return v;
}