void solve() {
    int n = ni();
    int[] a = na(n);
    for (int i = 0; i < n; i++) {
        if (a[i] == 0)
            a[i]--;
    }
    int[] from = new int[n - 1];
    int[] to = new int[n - 1];
    for (int i = 0; i < n - 1; i++) {
        from[i] = ni() - 1;
        to[i] = ni() - 1;
    }
    int[][] g = packU(n, from, to);
    int[] dp = new int[n];
    int[] ans = new int[n];
    dfs1(0, -1, a, dp, g);
    dfs2(0, -1, dp, ans, g, 0);
    for (int v : ans) {
        out.print(v + " ");
    }
    out.println();
}