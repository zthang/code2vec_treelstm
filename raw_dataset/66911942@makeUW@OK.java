int[][][] makeUW(int n, int[] from, int[] to) {
    int[][][] g = new int[n][][];
    int[] c = new int[n];
    for (int i = 0; i < from.length; i++) {
        c[from[i]]++;
        c[to[i]]++;
    }
    for (int i = 0; i < n; i++) g[i] = new int[c[i]][];
    for (int i = 0; i < from.length; i++) {
        g[from[i]][--c[from[i]]] = new int[] { to[i], i };
        g[to[i]][--c[to[i]]] = new int[] { from[i], i };
    }
    return g;
}