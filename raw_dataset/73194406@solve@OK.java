public void solve(int testNumber, FastReader s, PrintWriter w) {
    int n = s.nextInt();
    a = new ArrayList[n];
    for (int i = 0; i < n; i++) a[i] = new ArrayList<>();
    color = new int[n];
    dp = new int[n];
    ans = new int[n];
    for (int i = 0; i < n; i++) {
        color[i] = s.nextInt();
        if (color[i] == 0)
            color[i] = -1;
    }
    for (int i = 1; i < n; i++) {
        int u = s.nextInt() - 1, v = s.nextInt() - 1;
        a[u].add(v);
        a[v].add(u);
    }
    dfs(0, -1);
    ans[0] = dp[0];
    for (int i : a[0]) dfs2(i, 0);
    for (int i : ans) w.print(i + " ");
}