public static int[][] packGraph(int[] from, int[] to, int n) {
    int[][] g = new int[n + 1][];
    int[] p = new int[n + 1];
    for (int i : from) p[i]++;
    for (int i : to) p[i]++;
    for (int i = 0; i <= n; i++) g[i] = new int[p[i]];
    for (int i = 0; i < from.length; i++) {
        g[from[i]][--p[from[i]]] = to[i];
        g[to[i]][--p[to[i]]] = from[i];
    }
    return g;
}