int find(int x) {
    int p = parent[x];
    while (p != parent[p]) {
        p = parent[p];
    }
    while (parent[x] != p) {
        int t = parent[x];
        parent[x] = p;
        x = t;
    }
    return p;
}