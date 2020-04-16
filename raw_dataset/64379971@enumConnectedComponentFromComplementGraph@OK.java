public static DJSet enumConnectedComponentFromComplementGraph(int[][] g) {
    int n = g.length;
    DJSet ds = new DJSet(n);
    // find mindegree node A
    int mind = 99999999;
    int argmind = -1;
    for (int i = 0; i < n; i++) {
        if (g[i].length < mind) {
            mind = g[i].length;
            argmind = i;
        }
    }
    Arrays.sort(g[argmind]);
    // connect A to nodes not in g[A]
    for (int i = 0, p = 0; i < n; i++) {
        if (p < g[argmind].length && g[argmind][p] == i) {
            p++;
        } else {
            ds.union(argmind, i);
        }
    }
    // O(m/n*n*alpha*log n)
    for (int e : g[argmind]) {
        Arrays.sort(g[e]);
        int p = 0;
        for (int i = 0; i < n; i++) {
            if (p < g[e].length && g[e][p] == i) {
                p++;
            } else {
                ds.union(e, i);
            }
        }
    }
    return ds;
}