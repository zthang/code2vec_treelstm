private int root(int x) {
    if (x == parent[x])
        return x;
    return parent[x] = root(parent[x]);
}