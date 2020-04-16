private int[][] buildGraph(int n, int m, int[] a, int[] b) {
    int[][] g = new int[n][];
    int[] cnt = new int[n];
    for (int i = 0; i < m; i++) {
        cnt[a[i]]++;
        cnt[b[i]]++;
    }
    for (int i = 0; i < n; i++) {
        g[i] = new int[cnt[i]];
        cnt[i] = 0;
    }
    for (int i = 0; i < m; i++) {
        g[a[i]][cnt[a[i]]++] = b[i];
        g[b[i]][cnt[b[i]]++] = a[i];
    }
    return g;
}