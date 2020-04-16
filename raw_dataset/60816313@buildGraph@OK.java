private int[][] buildGraph(int n, int m, int[] u, int[] v) {
    int[] cnt = new int[n];
    for (int i = 0; i < m; i++) {
        cnt[u[i]]++;
        cnt[v[i]]++;
    }
    int[][] g = new int[n][];
    for (int i = 0; i < n; i++) {
        g[i] = new int[cnt[i]];
        cnt[i] = 0;
    }
    for (int i = 0; i < m; i++) {
        g[u[i]][cnt[u[i]]++] = v[i];
        g[v[i]][cnt[v[i]]++] = u[i];
    }
    return g;
}