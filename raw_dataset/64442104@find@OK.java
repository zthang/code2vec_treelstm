int find(int x) {
    if (g[x] == x)
        return x;
    return g[x] = find(g[x]);
}