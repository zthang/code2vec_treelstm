int[][] readGraph(int n, int m, FastScanner fs) {
    int[][] res = new int[n][];
    int[] deg = new int[n];
    int[][] es = new int[m][2];
    for (int i = 0; i < m; i++) {
        es[i][0] = fs.nextInt() - 1;
        es[i][1] = fs.nextInt() - 1;
        deg[es[i][0]]++;
        deg[es[i][1]]++;
    }
    for (int i = 0; i < n; i++) {
        res[i] = new int[deg[i]];
        deg[i] = 0;
    }
    for (int i = 0; i < m; i++) {
        int u = es[i][0];
        int v = es[i][1];
        res[u][deg[u]++] = v;
        res[v][deg[v]++] = u;
    }
    return res;
}