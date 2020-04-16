public int findSet(int x) {
    while (x != parent[x]) {
        x = parent[x];
    }
    return parent[x];
}