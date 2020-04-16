void solve() {
    int n = ni(), m = ni();
    int[] deg = new int[n];
    int[][] es = new int[m][];
    for (int i = 0; i < m; i++) {
        int f = ni() - 1, t = ni() - 1;
        if (f > t) {
            int d = f;
            f = t;
            t = d;
        }
        es[i] = new int[] { f, t };
        deg[f]++;
        deg[t]++;
    }
    int[][] g = new int[n][];
    for (int i = 0; i < n; i++) g[i] = new int[deg[i]];
    int[] ps = new int[n];
    for (int[] e : es) {
        g[e[0]][ps[e[0]]++] = e[1];
    }
    long ans = 0;
    for (int i = 0; i < n; i++) {
        ans += (long) ps[i] * (deg[i] - ps[i]);
    }
    out.println(ans);
    for (int Q = ni(); Q > 0; Q--) {
        int x = ni() - 1;
        ans -= (long) ps[x] * (deg[x] - ps[x]);
        for (int k = 0; k < ps[x]; k++) {
            int e = g[x][k];
            ans -= (long) ps[e] * (deg[e] - ps[e]);
            g[e][ps[e]++] = x;
            ans += (long) ps[e] * (deg[e] - ps[e]);
        }
        ps[x] = 0;
        out.println(ans);
    }
}