void solve() {
    int n = ni(), m = ni();
    int[][] es = new int[n - 1][];
    for (int i = 0; i < n - 1; i++) {
        es[i] = new int[] { ni() - 1, ni() - 1, ni() };
    }
    int[][] Q = new int[m][];
    for (int i = 0; i < m; i++) {
        Q[i] = new int[] { ni(), i };
    }
    Arrays.sort(es, (int[] x, int[] y) -> x[2] - y[2]);
    Arrays.sort(Q, (int[] x, int[] y) -> x[0] - y[0]);
    DJSet ds = new DJSet(n);
    long tot = 0;
    long[] ans = new long[m];
    int p = 0;
    for (int[] q : Q) {
        while (p < n - 1 && es[p][2] <= q[0]) {
            int f = ds.root(es[p][0]);
            tot -= -(long) ds.upper[f] * (-(long) ds.upper[f] - 1) / 2;
            int s = ds.root(es[p][1]);
            tot -= -(long) ds.upper[s] * (-(long) ds.upper[s] - 1) / 2;
            ds.union(es[p][0], es[p][1]);
            int u = ds.root(es[p][0]);
            tot += -(long) ds.upper[u] * (-(long) ds.upper[u] - 1) / 2;
            p++;
        }
        ans[q[1]] = tot;
    }
    for (long v : ans) {
        out.print(v + " ");
    }
    out.println();
}