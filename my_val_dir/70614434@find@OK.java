static int find(int n) {
    if (parent[n] < 0)
        return n;
    else
        parent[n] = find(parent[n]);
    return parent[n];
}