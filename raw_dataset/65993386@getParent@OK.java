int getParent(int v) {
    if (parent[v] == v)
        return v;
    return parent[v] = getParent(parent[v]);
}