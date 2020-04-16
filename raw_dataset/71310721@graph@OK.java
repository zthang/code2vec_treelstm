private int[][] graph(int n, int m, int[] x, int[] y) {
    int[] cnt = new int[n];
    for (int i = 0; i < m; i++) {
        cnt[x[i]]++;
        cnt[y[i]]++;
    }
    int[][] g = new int[n][];
    for (int i = 0; i < n; i++) {
        g[i] = new int[cnt[i]];
        cnt[i] = 0;
    }
    for (int i = 0; i < m; i++) {
        g[x[i]][cnt[x[i]]++] = y[i];
        g[y[i]][cnt[y[i]]++] = x[i];
    }
    for (int i = 0; i < n; i++) {
        if (cnt[i] != g[i].length) {
            throw new RuntimeException("Botva!");
        }
    }
    return g;
}