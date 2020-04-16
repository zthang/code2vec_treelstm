void solve() {
    int t = ni();
    while (t-- > 0) {
        int n = ni(), m = ni();
        int X = ni() - 1, Y = ni() - 1;
        a = new ArrayList[n];
        for (int i = 0; i < n; i++) a[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int u = ni() - 1, v = ni() - 1;
            a[u].add(v);
            a[v].add(u);
        }
        HashSet<Integer> fx = new HashSet<>();
        HashSet<Integer> fy = new HashSet<>();
        dfs(X, Y, fx);
        dfs(Y, X, fy);
        long x = 0;
        for (int xc : fx) {
            if (!fy.contains(xc))
                x++;
        }
        long y = fy.size() - (fx.size() - x);
        out.println((x - 1) * (y - 1));
    }
}