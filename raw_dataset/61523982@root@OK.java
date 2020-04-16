int root(int n) {
    while (parent[n] != n) {
        parent[n] = parent[parent[n]];
        n = parent[n];
    }
    return n;
}