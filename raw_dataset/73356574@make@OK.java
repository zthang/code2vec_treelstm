int[][] make(int n, int[] from, int[] to, int e, boolean f) {
    int[][] g = new int[n][];
    int[] cnt = new int[n];
    for (int i = 0; i < e; i++) {
        cnt[from[i]]++;
        if (f)
            cnt[to[i]]++;
    }
    for (int i = 0; i < n; i++) g[i] = new int[cnt[i]];
    for (int i = 0; i < e; i++) {
        g[from[i]][--cnt[from[i]]] = to[i];
        if (f)
            g[to[i]][--cnt[to[i]]] = from[i];
    }
    return g;
}