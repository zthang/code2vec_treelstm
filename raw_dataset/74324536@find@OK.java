static int find(int v, int[] parent) {
    if (parent[v] == v)
        return v;
    else
        parent[v] = find(parent[v], parent);
    return parent[v];
}