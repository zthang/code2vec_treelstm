public static int[][][] packGraphW(int[] from, int[] to, int[] w, int n, int m) {
    int[][][] g = new int[n + 1][][];
    int[] p = new int[n + 1];
    for (int i = 0; i < m; i++) p[from[i]]++;
    for (int i = 0; i < m; i++) p[to[i]]++;
    for (int i = 0; i <= n; i++) g[i] = new int[p[i]][2];
    for (int i = 0; i < m; i++) {
        --p[from[i]];
        g[from[i]][p[from[i]]][0] = to[i];
        g[from[i]][p[from[i]]][1] = w[i];
        --p[to[i]];
        g[to[i]][p[to[i]]][0] = from[i];
        g[to[i]][p[to[i]]][1] = w[i];
    }
    return g;
}