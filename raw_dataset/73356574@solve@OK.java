void solve(int TC) throws Exception {
    int n = ni();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) a[i] = ni() == 1 ? 1 : -1;
    int[] from = new int[n - 1], to = new int[n - 1];
    for (int i = 0; i < n - 1; i++) {
        from[i] = ni() - 1;
        to[i] = ni() - 1;
    }
    int[][] g = make(n, from, to, n - 1, true);
    int[] ans = new int[n], val = new int[n];
    dfs(g, val, a, 0, -1);
    dfs2(g, ans, val, 0, -1);
    for (int i : ans) p(i + " ");
    pn("");
}