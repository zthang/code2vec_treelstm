void solve() {
    int n = ni(), m = ni();
    int[] from = new int[m];
    int[] to = new int[m];
    for (int i = 0; i < m; i++) {
        from[i] = ni() - 1;
        to[i] = ni() - 1;
    }
    int[][] g = packU(n, from, to);
    DJSet ds = enumConnectedComponentFromComplementGraph(g);
    if (ds.count() != 3) {
        out.println(-1);
    } else {
        for (int i = 0; i < n; i++) {
            for (int e : g[i]) {
                if (ds.equiv(i, e)) {
                    out.println(-1);
                    return;
                }
            }
        }
        int[] clus = new int[n];
        Arrays.fill(clus, -1);
        int gen = 1;
        for (int i = 0; i < n; i++) {
            if (ds.upper[i] < 0) {
                clus[i] = gen++;
            }
        }
        for (int i = 0; i < n; i++) {
            out.print(clus[ds.root(i)] + " ");
        }
        out.println();
    }
}