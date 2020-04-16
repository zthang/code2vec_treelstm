public static int[][][] packGraphWDirected(int[] from, int[] to, int[] w, int n, int m) {
    int[][][] g = new int[n + 1][][];
    int[] p = new int[n + 1];
    for (int i = 0; i < m; i++) p[from[i]]++;
    for (int i = 0; i <= n; i++) g[i] = new int[p[i]][2];
    for (int i = 0; i < from.length; i++) {
        --p[from[i]];
        g[from[i]][p[from[i]]][0] = to[i];
        g[from[i]][p[from[i]]][1] = w[i];
    }
    return g;
}