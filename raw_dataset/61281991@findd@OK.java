static int findd(int a) {
    if (parent[a] != a) {
        parent[a] = findd(parent[a]);
    }
    return parent[a];
}