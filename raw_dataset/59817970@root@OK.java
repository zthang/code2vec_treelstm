private int root(int b) {
    if (parent[b] != b) {
        return parent[b] = root(parent[b]);
    }
    return b;
}