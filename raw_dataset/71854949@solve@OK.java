static void solve() {
    int n = ir.nextInt();
    int m = ir.nextInt();
    int k = ir.nextInt();
    int[] a = ir.nextIntArray(k);
    Graph[] g = new Graph[n];
    for (int i = 0; i < n; i++) {
        g[i] = new Graph();
    }
    for (int i = 0; i < m; i++) {
        int x = ir.nextInt() - 1;
        int y = ir.nextInt() - 1;
        g[x].add(new long[] { y, 1 });
        g[y].add(new long[] { x, 1 });
    }
    long[] x = dijkstra(0, g);
    long[] y = dijkstra(n - 1, g);
    long[][] p = new long[k][];
    for (int i = 0; i < k; i++) {
        p[i] = new long[] { x[a[i] - 1], y[a[i] - 1] };
    }
    Arrays.sort(p, new Comparator<long[]>() {

        public int compare(long[] A, long[] B) {
            return Long.compare(A[0], B[0]);
        }
    });
    long[] s = new long[k];
    long[] t = new long[k];
    long[] u = new long[k + 1];
    for (int i = 0; i < k; i++) {
        s[i] = p[i][0];
        t[i] = p[i][1];
        u[i] = Math.max(t[i], u[i + 1]);
    }
    long lb = 0;
    long ub = x[n - 1] + 1;
    while (ub - lb > 1) {
        long mid = (ub + lb) / 2;
        if (ok(mid, s, t, u)) {
            lb = mid;
        } else {
            ub = mid;
        }
    }
    out.println(lb);
}