static int find(int[] g, int x) {
    return g[x] = g[x] == x ? x : find(g, g[x]);
}