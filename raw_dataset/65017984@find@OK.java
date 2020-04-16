int find(int a) {
    int p = a;
    while (parent[a] != a) a = parent[a];
    while (parent[p] != a) {
        int t = parent[p];
        parent[p] = a;
        p = t;
    }
    return a;
}