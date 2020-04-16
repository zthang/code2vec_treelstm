void solve() {
    int n = ni(), m = ni();
    int[] from = new int[m];
    int[] to = new int[m];
    for (int i = 0; i < m; i++) {
        from[i] = ni() - 1;
        to[i] = ni() - 1;
    }
    int[][] g = packU(n, from, to);
    DJSet ds = new DJSet(n);
    int arg = 0;
    for (int i = 0; i < n; i++) {
        if (g[i].length < g[arg].length) {
            arg = i;
        }
    }
    Arrays.sort(g[arg]);
    for (int i = 0; i < n; i++) {
        if (Arrays.binarySearch(g[arg], i) < 0) {
            ds.union(arg, i);
        }
    }
    for (int e : g[arg]) {
        Arrays.sort(g[e]);
        for (int i = 0; i < n; i++) {
            if (Arrays.binarySearch(g[e], i) < 0) {
                ds.union(e, i);
            }
        }
    }
    out.println(ds.count() - 1);
}