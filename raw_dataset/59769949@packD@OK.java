static int[][] packD(int n, int[] from, int[] to) {
    int[][] g = new int[n][];
    int[] p = new int[n];
    for (int f : from) p[f]++;
    for (int i = 0; i < n; i++) g[i] = new int[p[i]];
    for (int i = 0; i < from.length; i++) {
        g[from[i]][--p[from[i]]] = to[i];
    }
    return g;
}