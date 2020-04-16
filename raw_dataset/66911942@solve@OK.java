void solve(int TC) throws Exception {
    int n = ni();
    int[] from = new int[2 * n - 1], to = new int[2 * n - 1];
    long[] w = new long[2 * n - 1];
    for (int i = 0; i < 2 * n - 1; i++) {
        from[i] = ni() - 1;
        to[i] = ni() - 1;
        w[i] = nl();
    }
    int[][][] g = makeUW(n * 2, from, to);
    int[] sub = new int[n * 2];
    long[] a = dfs(g, w, sub, 0, -1);
    pn(a[0] + " " + a[1]);
}