private int[][] buildGraph(int n, int m, int[] from, int[] to) {
    int[] cnt = new int[n];
    for (int i = 0; i < m; i++) {
        cnt[from[i]]++;
    }
    int[][] g = new int[n][];
    for (int i = 0; i < n; i++) {
        g[i] = new int[cnt[i]];
        cnt[i] = 0;
    }
    for (int i = 0; i < m; i++) {
        g[from[i]][cnt[from[i]]++] = to[i];
    }
    return g;
}