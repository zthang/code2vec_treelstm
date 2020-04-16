void solve() {
    int n = ni(), Q = ni();
    int[][] es = new int[n - 1][];
    for (int i = 0; i < n - 1; i++) {
        es[i] = new int[] { ni() - 1, ni() - 1, ni() };
    }
    int[][] qs = new int[Q][];
    for (int i = 0; i < Q; i++) qs[i] = new int[] { ni(), i };
    Arrays.sort(qs, new Comparator<int[]>() {

        public int compare(int[] a, int[] b) {
            return a[0] - b[0];
        }
    });
    Arrays.sort(es, new Comparator<int[]>() {

        public int compare(int[] a, int[] b) {
            return a[2] - b[2];
        }
    });
    DJSet ds = new DJSet(n);
    int p = 0;
    long ans = 0;
    long[] anss = new long[Q];
    for (int[] q : qs) {
        while (p < es.length && es[p][2] <= q[0]) {
            int l = ds.root(es[p][0]);
            ans -= -(long) ds.upper[l] * (-ds.upper[l] - 1) / 2;
            int r = ds.root(es[p][1]);
            ans -= -(long) ds.upper[r] * (-ds.upper[r] - 1) / 2;
            ds.union(es[p][0], es[p][1]);
            l = ds.root(es[p][0]);
            ans += -(long) ds.upper[l] * (-ds.upper[l] - 1) / 2;
            p++;
        }
        anss[q[1]] = ans;
    }
    for (long v : anss) {
        out.print(v + " ");
    }
}