int get(int v) {
    if (v == parent[v])
        return v;
    return parent[v] = get(parent[v]);
}