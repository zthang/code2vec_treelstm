int[][] creategraph(int n, int m) {
    int[][] g = new int[n + 1][];
    int[] from = new int[m];
    int[] to = new int[m];
    int[] ct = new int[n + 1];
    for (int i = 0; i < m; i++) {
        from[i] = ni();
        to[i] = ni();
        ct[from[i]]++;
        ct[to[i]]++;
    }
    int[] parent = new int[n + 1];
    for (int i = 0; i < n + 1; i++) g[i] = new int[ct[i]];
    for (int i = 0; i < m; i++) {
        g[from[i]][--ct[from[i]]] = to[i];
        g[to[i]][--ct[to[i]]] = from[i];
    }
    return g;
}